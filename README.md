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

### Post Module

<p align="center">
  <img src="https://www.linkpicture.com/q/SocialMediaPlatform_3.png"/>
</p>

### Analytics Module

<p align="center">
  <img src="https://www.linkpicture.com/q/SocialMediaPlatform_4.png"/>
</p>

## Author
- [Abhishek Das](https://github.com/abhidas0810)
