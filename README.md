# ooredoo-back-end

This is a Demo rest API using Spring Boot, mySQL running in docker containers defined by docker-compose yml file.

## Requirements
- Java 8
- Maven 3.3.9
- Docker 2.3.0.4
- Docker-compose 1.26.2

## Build and Run
Will build, package and create a new Docker image with the application
 
```mvn clean install```

- Launch an Application and a mySQL container in the application root directory :

```docker-compose up```

- start the spring boot application :

```mvn spring-boot:run```

Then spring boot application will be running on port 5020 : http://localhost:5020/

## Docker
The docker file defines a container based on Java with the jar created by maven package

