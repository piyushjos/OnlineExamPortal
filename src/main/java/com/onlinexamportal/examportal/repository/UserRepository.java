package com.onlinexamportal.examportal.repository;

import com.onlinexamportal.examportal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}