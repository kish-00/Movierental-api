# Movierenting api built with Spring Boot Security JWT Access Tokens

## Introduction

- This project encompasses two security concepts, Authentication.
    - Authentication is verifying who the user is, do we know them? Do they exist in the database? Are their credentials correct? If they are known to you then allow them into the application and give them a token which they will use to access resources (API endpoints) in the application.
## Tech stack

- Dependencies
    - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)  - Persists data in SQL stores with Java persistence API using spring data and Hibernate.
    - [MySQL Driver](https://spring.io/guides/gs/accessing-data-mysql/)  - MySQL JDBC and R2DBC driver.
    - [Spring Web](https://spring.io/guides/gs/spring-boot/)  - Build web, including RESTFUL applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
    - [Spring Security](https://spring.io/projects/spring-security)  - Highly customizable authentication and access-control framework for spring applications.
    - [Spring Dev tools](https://www.baeldung.com/spring-boot-devtools) - Provides fast application restarts, Live reload and configurations for enhanced development experience.
    - [Lombok](https://projectlombok.org/) - Java annotation library which helps reduce boilerplate code.
   
## Requirements

* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

## Quick start

1. `mvn clean spring-boot:run`
3. Point your browser to [http://localhost:8080/](http://localhost:8080/)

## Screenshots
-Login to get the access token.

<img src = "https://github.com/kish-00/Movierental-api/blob/main/assets/authenticate.png" />

-When you try to access an api endpoint without authentication.

<img src = "https://github.com/kish-00/Movierental-api/blob/main/assets/unauthorized_access.png" />

-Interacting with the API endpoints with authentication token.

<img src = "https://github.com/kish-00/Movierental-api/blob/main/assets/getActorId.png" />