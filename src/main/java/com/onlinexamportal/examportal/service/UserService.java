package com.onlinexamportal.examportal.service;
import com.onlinexamportal.examportal.dto.LoginRequest;
import com.onlinexamportal.examportal.dto.RegisterRequest;
import com.onlinexamportal.examportal.dto.UserResponse;
import com.onlinexamportal.examportal.model.User;
import com.onlinexamportal.examportal.model.Role;
import com.onlinexamportal.examportal.repository.UserRepository;
import com.onlinexamportal.examportal.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




    @Service
    public class UserService {
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleRepository roleRepository;

        // Register method
        public UserResponse register(RegisterRequest request) {
            // Validate request
            System.out.println("RegisterRequest received: " + request);
            if (userRepository.existsByEmail(request.getEmail())) {
                throw new RuntimeException("Email already exists!");
            }

            // Create new user
            User user = new User();
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setUsername(request.getUsername());
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());

            // Set default role as USER
            Role userRole = roleRepository.findByRoleName("STUDENT" +
                            "" +
                            "")
                    .orElseThrow(() -> new RuntimeException("Default role not found"));
            user.setRole(userRole);

            // Save user
            User savedUser = userRepository.save(user);
            return convertToUserResponse(savedUser);
        }

        // Login method
        public UserResponse login(LoginRequest request) {
            // Find user by email
            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Check password
            if (!user.getPassword().equals(request.getPassword())) {
                throw new RuntimeException("Invalid password");
            }

            return convertToUserResponse(user);
        }

        // Convert User to UserResponse
        private UserResponse convertToUserResponse(User user) {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setUsername(user.getUsername());
            response.setEmail(user.getEmail());
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setRole(user.getRole().getRoleName());
            return response;
        }
    }

