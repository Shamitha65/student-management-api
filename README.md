# Student Management API

A Spring Boot REST API for managing students and departments using Spring Data JPA and MySQL.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Jakarta Validation
- Postman

## Features

- Create, read, update and delete students
- Create, read, update and delete departments
- Student and department relationship using JPA
- Input validation
- Search students by name
- Find students by department
- Custom JPA query using `@Query`

## Project Structure

student-management-api
├── src
│   └── main
│       ├── java
│       │   └── com.example.studentapi
│       │       ├── controller
│       │       ├── entity
│       │       ├── repository
│       │       └── service
│       └── resources
│           └── application.properties
├── pom.xml
└── README.md