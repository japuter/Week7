Sports Time Tracker Application
Overview
This project is a Java-based Sports Time Tracker application that allows users to:

Log sports activities.
View logged activities.
Calculate the total time spent on sports during a week.
The application can be run locally or in a Docker container, and it is also integrated with Jenkins for Continuous Integration and Deployment (CI/CD).

Table of Contents

Technologies Used

How to Build and Run Locally

How to Build and Run in Docker

How to Run the Jenkins Pipeline

Technologies Used

Java: Version 21
Maven: For building the project and managing dependencies.
JUnit: For unit testing.
Docker: For containerizing the application.
Jenkins: For CI/CD pipeline automation.
GitHub: Version control.
How to Build and Run Locally
Prerequisites
Java 21 or later installed.
Maven installed.
Steps to Run Locally
Clone the repository:

bash
Copy code
git clone https://github.com/japuter/Week7.git
cd Week7
Build the project using Maven:

bash
Copy code
mvn clean install
Run the application: After the project is built, you can run the application with:

bash
Copy code
java -jar target/Week7-1.0-SNAPSHOT.jar
Using the Application: The application will present a menu with the following options:

1: Log a new activity.
2: View logged activities.
3: Calculate total time spent on activities.
4: Exit the application.
How to Build and Run in Docker
Prerequisites
Docker installed on your machine. You can install Docker Desktop from here.
Steps to Run in Docker
Clone the repository:

bash
Copy code
git clone https://github.com/japuter/Week7.git
cd Week7
Build the Docker image: Build the Docker image using the provided Dockerfile:

bash
Copy code
docker build -t japuter/sports-time-tracker:latest .
Run the Docker container: Once the image is built, you can run the application inside a Docker container:

bash
Copy code
docker run -it --rm japuter/sports-time-tracker:latest
Using the Application: You will see the same options as in the local run:

1: Log a new activity.
2: View logged activities.
3: Calculate total time spent on activities.
4: Exit the application.
How to Run the Jenkins Pipeline
Prerequisites
Jenkins installed and configured (either locally or on a server).
GitHub repository linked to Jenkins.
Steps to Run the Jenkins Pipeline
Clone the repository: Make sure your Jenkins job is pulling the code from this GitHub repository: https://github.com/japuter/Week7.

Jenkins Pipeline Setup: The pipeline is defined in the Jenkinsfile located in the root directory of this repository. It automates the following steps:

Checkout the code from GitHub.
Build the Java application using Maven.
Run Tests using JUnit.
Build the Docker image.
Push the Docker image to Docker Hub.
Run the Pipeline:

Navigate to your Jenkins job dashboard.
Click Build Now to run the pipeline.
Pipeline Output:

View the build logs under Console Output in Jenkins.
Once the pipeline completes, the Docker image should be available on Docker Hub in the japuter/sports-time-tracker repository.
