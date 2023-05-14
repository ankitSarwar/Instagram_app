<h1 align="center"> Instagram_app </h1>

* Implemented CRUD operations with data validation, MySQL database configuration, 
Swagger integration, authentication and established table relationships, authentication 
using “MD-5” algorithm

* Tech stack used: Spring Boot, Hibernate, MySQL, OOPs, Postman, Swagger, and Java
>### Prerequisites
* ![MySql](https://img.shields.io/badge/DBMS-MYSQL%205.7%20or%20Higher-red)
 * ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-green)


* ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-yellow)


>### Description
The Instagram App is a backend application that focuses on creating the basic design for an Instagram-like platform. It includes models for User and Post, along with controllers and APIs for user authentication and post management.

>### Model
 ## User
 - Represents a user of the application.

- firstName (String): The first name of the user.
- lastName (String): The last name of the user.
- age (Integer): The age of the user.
- email (String): The email address of the user.
- phoneNumber (String): The phone number of the user.

## Post
 - Represents a post in the application.

- postId (Integer): The ID of the post.
- createdDate (Timestamp): The timestamp when the post was created.
- updatedDate (Timestamp): The timestamp when the post was last updated.
- postData (String): The data of the post (can be dummy string for now).
- user (User): The user who created the post.

## AuthenticationToken
Represents an authentication token for a user.

- tokenId (Long): The ID of the token.
- token (String): The token string for authentication.
- tokenCreationDate (LocalDate): The date when the token was created.

>### user (User): The user associated with the token.

## Controllers and APIs
>### UserController
Handles user-related operations and authentication.

>### APIs:
- POST /user/add/signup: Creates a new user with the provided details.
- POST /user/add/signin: Authenticates the user and generates an authentication token.
- PUT /user/update: Updates the details of an existing user.

>### PostController
Handles post-related operations.

>### APIs:

- POST /post/save: Saves a new post with the provided data.
- GET /post/{id}: Retrieves a post by its ID.

>## Project Summary
This project demonstrates the basic usage of Spring Boot and Hibernate to build a RESTful API for managing employees and addresses. Further enhancements can be made to add authentication and authorization, error handling, pagination, etc.
