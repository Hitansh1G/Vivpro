# Song Application

This is a Spring Boot application for managing songs. The application provides RESTful APIs for loading data, retrieving songs, and rating songs.

## Features

- Load data from a file
- Retrieve all songs with pagination
- Retrieve a song by its title
- Rate a song

## Technologies Used

- Java 17
- Spring Boot 3.3.1
- Spring Data JPA
- H2 Database (for development)
- Gradle (for dependency management and build)

## Prerequisites

- JDK 17 or higher
- Gradle
- Docker (optional, for running the application in a container)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/song-application.git
cd song-application
```

### using gradle
1. build the project
```bash
./gradlew clean build
```
2. Run the application
```bash
./gradlew bootRun
```


Running Tests
To run the tests, use the following command:
```bash
./gradlew test
```



