# Online Exam Portal - Documentation

## Overview
The Online Exam Portal is a **Spring Boot** application that facilitates user authentication and exam management. The backend is built using **Spring Boot**, **Spring Data JPA**, and **MySQL**, while the application is containerized using **Docker** and **Docker Compose**.

## Project Structure

```
examportal/
├── src/main/java/com/onlinexamportal/examportal/
│   ├── controller/
│   │   ├── AuthController.java
│   ├── dto/
│   │   ├── LoginRequest.java
│   │   ├── RegisterRequest.java
│   │   ├── UserResponse.java
│   ├── model/
│   │   ├── Role.java
│   │   ├── User.java
│   ├── repository/
│   │   ├── RoleRepository.java
│   │   ├── UserRepository.java
│   ├── service/
│   │   ├── UserService.java
├── application.properties
├── pom.xml
├── Dockerfile
├── docker-compose.yml
```

### **Key Components**

#### **1. Configuration Files**
- **`pom.xml`** - Defines dependencies and build configurations (Spring Boot, MySQL, JPA, and Web support).
- **`application.properties`** - Configures database connection (MySQL), Hibernate, and server port.
- **`Dockerfile`** - Defines how the Spring Boot application should be containerized.
- **`docker-compose.yml`** - Defines multi-container setup for MySQL and Spring Boot application.

#### **2. Entity Layer (Models)**
- **`User.java`** - Represents a user entity with fields such as `id`, `username`, `email`, `password`, `role`, etc.
- **`Role.java`** - Represents user roles (e.g., `STUDENT`, `ADMIN`).

#### **3. Repository Layer**
- **`UserRepository.java`** - Interface for database operations on `User` entity.
- **`RoleRepository.java`** - Interface for database operations on `Role` entity.

#### **4. Service Layer**
- **`UserService.java`** - Handles user registration, authentication, and user management logic.

#### **5. Controller Layer (REST API)**
- **`AuthController.java`** - Defines authentication-related endpoints for registration and login.

## **API Endpoints**

### **Authentication API**

#### **1. Register User**
**Endpoint:** `POST /api/auth/register`

**Request Body:**
```json
{
  "username": "testuser",
  "email": "test@example.com",
  "password": "securepassword",
  "firstName": "John",
  "lastName": "Doe"
}
```

**Response:**
```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com",
  "role": "STUDENT",
  "firstName": "John",
  "lastName": "Doe"
}
```

#### **2. User Login**
**Endpoint:** `POST /api/auth/login`

**Request Body:**
```json
{
  "email": "test@example.com",
  "password": "securepassword"
}
```

**Response:**
```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com",
  "role": "STUDENT",
  "firstName": "John",
  "lastName": "Doe"
}
```

## **Database Configuration**
MySQL is used as the database, and the connection is configured in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/exam_portal
spring.datasource.username=testuser
spring.datasource.password=testpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
server.port=8081
```

## **Running the Project**
### **1. Running Locally**
#### **Prerequisites**
- Java 21+
- Maven
- MySQL

#### **Steps to Run**
1. Clone the repository:
   ```sh
   git clone <repo-url>
   cd examportal
   ```
2. Configure the database (`application.properties`).
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

### **2. Running with Docker**
#### **Prerequisites**
- Docker
- Docker Compose

#### **Steps to Run**
1. Ensure Docker is installed and running.
2. Navigate to the project root and run:
   ```sh
   docker-compose up --build
   ```
3. The backend should be available at `http://localhost:8081`.

## **Future Enhancements**
- Implement JWT authentication.
- Introduce role-based access control.
- Add API documentation using Swagger.
- Develop a frontend using React or Angular.

This documentation provides a complete overview of the **Online Exam Portal**, its structure, API endpoints, and setup instructions. 🚀

