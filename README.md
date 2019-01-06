Spring Boot, MySQL, JPA, Hibernate Rest API

A Restful CRUD API for a simple To-Do list application using Spring Boot, MySQL, JPA and Hibernate.

Requirements:

    Java - 1.8.x
    Maven - 3.x.x
    MySQL - 5.x.x

Steps to Setup

1. Clone the application

***** GET CORRECT GIT ******

git clone https://github.com/***.git

2. Create MySQL database

mysql> CREATE DATABASE user_data;
mysql> USE user_data;

3. Change mysql username and password as per your installation

    open src/main/resources/application.properties

    change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

***** ADD INSTRUCTIONS *****

The app will start running at http://localhost:8080.

The app defines following CRUD APIs.

GET /api/v1/tasks

POST /api/v1/tasks

GET /api/v1/tasks/{taskId}

PUT /api/v1/tasks/{taskId}

DELETE /api/v1/tasks/{taskId}

You can test them using postman or any other rest client. Postman tests are provided in **** GET DIRECTORY NAME, ADD INSTRUCTIONS ON HOW TO USE POSTMAN TESTS *****