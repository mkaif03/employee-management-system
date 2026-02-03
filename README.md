# Employee Management System

A backend-heavy Employee Management System built using **Spring Boot**, **Spring Security**, **Thymeleaf**, and **MySQL**.

This project demonstrates real-world backend concepts including authentication, authorization, validation, layered architecture, and role-based UI access.

---

##  Features

- User Authentication & Authorization (ADMIN / USER roles)
- Employee CRUD Operations
- Role-based access control
- Server-side validation
- Thymeleaf-based UI
- Bootstrap styling
- Secure password handling
- MySQL database integration

---

##  Tech Stack

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- Bootstrap 5
- MySQL
- Maven

---

##  Roles

| Role  | Permissions |
|------|------------|
| ADMIN | Add, Edit, Delete employees |
| USER  | View employees |

---

##  Configuration

Database credentials are loaded using environment variables:

```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
