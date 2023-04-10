# Social Media Platform

<p align="center">
  <img src="https://www.linkpicture.com/q/SocialMediaPlatform.png"/>
</p>

## About

This project involves creating a simple social media platform with a backend API and analytics pages. The platform allows users to perform CRUD operations for user profiles and posts and like and unlike posts. The backend API includes User and Post models with unique identifiers, name, email, bio, content, created_at, updated_at, and likes fields. The analytics pages display data on user engagement and content popularity, such as the total number of likes and posts created by each user. The project aims to provide a straightforward social media platform with basic functionality and analytics to improve the user experience.

## Tech Stack

**Client:** Java, SpringBoot, Spring Data JPA, Hibernate

**RDBMS:** MySQL

**Testing:** Swagger


### Modules
- User Module
- Post Module
-	Analytics Module

<p align="center">
  <img src="https://www.linkpicture.com/q/SocialMediaPlatform_1.png"/>
</p>

##  Entity Relationship

![Social Media Platform (ER Diagram)](https://www.linkpicture.com/q/Social-Media-Platform-ER-Diagram.png)

## Run Locally

Clone the project

```bash
  git clone https://github.com/abhidas0810/SocialMediaPlatform.git
```

Go to the project resources

-  src/main/resources and modify the MySQL login details in the application.properties file to match the system on which the application will be executed.

Run the main file

- src/main/java/com/socialMediaPlatform/SocialMediaPlatformApplication.java

Start the server

 - http://localhost:8888/swagger-ui/index.html#/

## API Module Endpoints

### User Module

<p align="center">
  <img src="https://www.linkpicture.com/q/SocialMediaPlatform_2.png"/>
</p>

* POST - http://localhost:8888/users : Create a new user.
  name must have 1 to 50 characters.
  email must be in valid email format.
  bio must have 0 to 200 characters.

* GET - http://localhost:8888/users/id : Retrieve a user by id.
* PUT - http://localhost:8888/users/id : Update a user's name or bio by id.
  name must have 1 to 50 characters.
  bio must have 0 to 200 characters.

* DELETE - http://localhost:8888/users/id : Delete a user by id.

### Post Module

<p align="center">
  <img src="https://www.linkpicture.com/q/SocialMediaPlatform_3.png"/>
</p>

* POST - http://localhost:8888/posts: Create a new post. The request should include the user_id.
  content must have 1 to 300 characters. 

* GET - http://localhost:8888/posts/id : Retrieve a post by id.
* PUT - http://localhost:8888/posts/id : Update a post's content by id.
  content must have 1 to 300 characters.

* DELETE - http://localhost:8888/posts/id : Delete a post by id.
* POST - http://localhost:8888/posts/id/like : Increment the like count of a post by id.
* POST - http://localhost:8888/posts/id/unlike : Decrement the like count of a post by id. The count should not go below 0.

### Analytics Module

<p align="center">
  <img src="https://www.linkpicture.com/q/SocialMediaPlatform_4.png"/>
</p>

* GET - http://localhost:8888/analytics/users : Retrieve the total number of users.
* GET - http://localhost:8888/analytics/users/top-active : Retrieve the top 5 most active users, based on the number of posts.
* GET - http://localhost:8888/analytics/posts : Retrieve the total number of posts.
* GET - http://localhost:8888/analytics/posts/top-liked : Retrieve the top 5 most liked posts.

## Author
- [Abhishek Das](https://github.com/abhidas0810)
