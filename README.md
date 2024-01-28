# TVMaze Task Project

This is a small project to access the public api, and to secure my own endpoints.

## Table of Contents
- [Requirements](#requirements)
- [Getting Started](#getting-started)
- [How to use](#how-to-use)
- [Part 1: src directory](#part-1-src-directory)
- [Part 2: Task2 directory](#part-2-task2-directory)
- [Swagger](#swagger)

## Requirements

- Java 17
- Spring Boot 3.2.2
- Swagger 3

## Getting Started

```bash
# Clone the repository
git clone https://github.com/aleksbako/TVMaze_Task.git

# Navigate to the project directory
cd TVMaze_Task

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

## How to use:
1. Start the application as indicated in the previous step.
2. Open either Swagger or Postman for accessing Endpoints.
3. Authenticate by providing a api-key in the header. The key can be found in /src/main/java/resources/application.properties file under the name api.key. 
4. Use the endpoints and send the api-key in the authentication header.


## Part 1: src directory:
The solutions for part 1 are located in the src directory.

## Part 2: Task2 directory:
The solutions for the part 2 are located in the README file in the directory Task2.

## Swagger:
To access the swagger api documentation you should go to the following page when running the application:
- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)