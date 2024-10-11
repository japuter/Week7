pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pull the code from your public GitHub repository
                git 'https://github.com/japuter/Week7'
            }
        }

        stage('Build') {
            steps {
                // Use Windows batch commands to build the Java application using Maven
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run the tests using Maven on Windows
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image using Docker on Windows
                    bat 'docker build -t japuter/sports-time-tracker:latest .'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Use Jenkins credentials with the ID 'dockerhub-credentials'
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                    // Log in to Docker Hub and push the Docker image using batch commands
                    bat 'docker login -u %DOCKER_HUB_USERNAME% -p %DOCKER_HUB_PASSWORD%'
                    bat 'docker push %DOCKER_HUB_USERNAME%/sports-time-tracker:latest'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
