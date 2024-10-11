# Use an official OpenJDK 21 runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the Docker container
WORKDIR /app

# Copy the compiled JAR file into the Docker container
COPY target/Week7-1.0-SNAPSHOT.jar /app/sports-time-tracker.jar

# Command to run your Java application
ENTRYPOINT ["java", "-jar", "/app/sports-time-tracker.jar"]
