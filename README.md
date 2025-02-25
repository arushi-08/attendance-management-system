# attendance-management-system


Here's a clean, professional README tailored to highlight your backend engineering skills and Java/Spring Boot learning:


# Attendance Management System

A scalable backend system for role-based attendance tracking, built with Java and Spring Boot.

![Java](https://img.shields.io/badge/Java-17-blue)
![SpringBoot](https://img.shields.io/badge/SpringBoot-3.1-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)

## Features

**Secure Access Control**  
- Role-Based Access Control (RBAC) with Spring Security  
- 3-tier authorization: Admin, Teacher, Student  

**Efficient Data Handling**  
- RESTful APIs for CRUD operations on attendance records  
- Hibernate ORM for optimized MySQL interactions  
- Batch initialization via `CommandLineRunner`

## Tech Stack

**Backend**  
- Java 17 | Spring Boot 3.1

1. **Configure Database**  
```sql
CREATE DATABASE attendance_system;
UPDATE application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/attendance_system
spring.datasource.username=<your_user>
spring.datasource.password=<your_password>
```

2. **Build & Run**  
```bash
mvn clean install
mvn spring-boot:run
```

## Testing

Run unit/integration tests:  
```bash
mvn test
```

Test coverage report:  
`target/site/jacoco/index.html`  
