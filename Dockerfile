#FROM openjdk:17-jdk-slim
#WORKDIR /app
#COPY build/libs/Song-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM gradle:7.3.3-jdk17 AS builder
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle ./gradle
COPY . .
RUN ./gradlew build

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/Song-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java", "-jar", "./app.jar"]
