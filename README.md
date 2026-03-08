# JWT_AUTHENTICATION

A Spring Boot-based authentication system that uses JWT (JSON Web Token) for secure, stateless user authentication. This service supports user registration, login, and token-based authorization for protected endpoints.

Features

User registration with secure password storage (BCrypt hashing)

User login with JWT token generation

Role-based authorization

JWT token validation and expiration handling

Spring Security integration

Easily extendable for microservices architecture

Tech Stack

Java 17

Spring Boot 3

Spring Security

Spring Data JPA

MySQL


Getting Started
Prerequisites

Java 17+

Maven 3.8+

MySQL database

IDE (IntelliJ, Eclipse, VSCode)

Setup

Clone the repository:

git clone https://github.com/yourusername/jwt-authentication.git
cd jwt-authentication

Configure application.properties or application.yml with your database credentials and JWT secret:

spring.datasource.url=jdbc:mysql://localhost:3306/jwt_db
spring.datasource.username=youruser
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

jwt.secret=yourSuperSecretKey
jwt.expiration=3600000   # Token validity in milliseconds

Build and run:

mvn clean install
mvn spring-boot:run

