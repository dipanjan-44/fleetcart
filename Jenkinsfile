pipeline {
    agent any

    environment {
        IMAGE_NAME = "floki69/fleetcart-app"
        CONTAINER_NAME = "fleetcart-container"
        PORT = "8083"
    }

    stages {

        stage('Build Maven Project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Push Docker Image') {
            steps {
                bat 'docker push %IMAGE_NAME%'
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker stop %CONTAINER_NAME% || exit 0'
                bat 'docker rm %CONTAINER_NAME% || exit 0'
                bat 'docker run -d -p %PORT%:8080 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }
    }
}