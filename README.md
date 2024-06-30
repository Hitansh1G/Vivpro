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
## Prerequisites

- [Docker](https://www.docker.com/products/docker-desktop) installed on your machine.

## Getting Started

Follow these steps to run the application using Docker.

### Step 1: Docker Login (if necessary)

Log in to Docker Hub using your credentials:

```sh
docker login
```
### Step 2: Pull the Docker Image

Pull the Docker image from Docker Hub:

```sh
docker pull hitansh1g/song-app:v2
```

### Step 3: Run the Docker Container
Run the Docker container, mapping port 8080 on your host to port 8080 in the container:
```sh
docker run -d -p 8080:8080 hitansh1g/song-app:v2 
```

### Step 4: Access the Application
Once the Docker container is running, you can access the application by opening a web browser and navigating to:

http://localhost:8080/api/songs/load


Endpoints
Here are the available endpoints for the application:

GET /api/songs/load: Load data from a predefined JSON file.
GET /api/songs: Retrieve a paginated list of songs.
GET /api/songs/{title}: Retrieve a song by its title.
POST /api/songs/{id}/rate: Rate a song by its ID.


Additional Notes

Ensure that the Docker daemon is running on your machine.
The application will use an in-memory database (H2) for this demonstration.


Troubleshooting

If you encounter any issues, ensure that:

Docker is installed and running.
The ports are not being used by other applications.
The Docker image was pulled successfully.




Running Tests
The test execution process will involve running a Docker container and then executing the tests within that container. Here are the steps:

Start the Docker Container with a Shell:

Start a Docker container from the image with an interactive shell:

docker run -it --entrypoint /bin/bash hitansh1g/song-app:v2


This command starts a Docker container and gives you an interactive shell (/bin/bash) within the container.

Run Tests Inside the Docker Container:

Once inside the container, navigate to the application directory (/app) where your code is located:

cd /app

Execute Gradle Test Commands:

Run Gradle commands to execute your tests. For example:

To run all tests:
./gradlew test

View Test Results:
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
## Prerequisites

- [Docker](https://www.docker.com/products/docker-desktop) installed on your machine.

## Getting Started

Follow these steps to run the application using Docker.

### Step 1: Docker Login (if necessary)

Log in to Docker Hub using your credentials:

```sh
docker login
```
### Step 2: Pull the Docker Image

Pull the Docker image from Docker Hub:

```sh
docker pull hitansh1g/song-app:v2
```

### Step 3: Run the Docker Container
Run the Docker container, mapping port 8080 on your host to port 8080 in the container:
```sh
docker run -d -p 8080:8080 hitansh1g/song-app:v2 
```

### Step 4: Access the Application
Once the Docker container is running, you can access the application by opening a web browser and navigating to:

http://localhost:8080/api/songs/load


## Endpoints

Here are the available endpoints for the application:

- **GET /api/songs/load**: Load data from a predefined JSON file.
- **GET /api/songs**: Retrieve a paginated list of songs.
- **GET /api/songs/{title}**: Retrieve a song by its title.
- **POST /api/songs/{id}/rate**: Rate a song by its ID.

## Additional Notes

Ensure that the Docker daemon is running on your machine.
The application will use an in-memory database (H2) for this demonstration.

## Troubleshooting

If you encounter any issues, ensure that:

- Docker is installed and running.
- The ports are not being used by other applications.
- The Docker image was pulled successfully.

## Running Tests

The test execution process will involve running a Docker container and then executing the tests within that container. Here are the steps:

1. **Start the Docker Container with a Shell:**

   Start a Docker container from the image with an interactive shell:

   ```sh
   docker run -it --entrypoint /bin/bash hitansh1g/song-app:v2
    ```
2. **Run Tests Inside the Docker Container:**

   Once inside the container, navigate to the application directory (`/app`) where your code is located:

   ```sh
   cd /app
   ```

3. **Execute Gradle Test Commands:**

Run Gradle commands to execute your tests. For example:

To run all tests:
   ```sh
./gradlew test
   ```

4. **View Test Results:**

   After the tests complete, you can view the test results in the console output. Gradle will provide a summary of test execution along with any failures or errors encountered.

   If you're using an IDE like IntelliJ IDEA or Eclipse, you can also view detailed test reports in the `build/reports/tests` directory of your project. These reports include information about individual test cases, their status (passed or failed), and any exceptions thrown during their execution.

   To open the test reports directly from the Docker container using a command-line interface, you can use tools like `cat` or `less` to view the contents of these files. For example:

   ```sh
   cat build/reports/tests/index.html
   ```


5. **View Test Results:**

After the tests complete, you can view the test results in the console output. Gradle will provide a summary of test execution along with any failures or errors encountered.






[//]: # ()
[//]: # (Running Tests)

[//]: # (To run the tests, use the following command:)

[//]: # (```bash)

[//]: # (./gradlew test)

[//]: # (```)

[//]: # ()




[//]: # (To run the tests, use the following command:)

[//]: # (```bash)

[//]: # (./gradlew test)

[//]: # (```)

[//]: # ()


