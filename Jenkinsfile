pipeline {
    agent any

    environment {
        IMAGE_NAME = "fleetcart-app"
        CONTAINER_NAME = "fleetcart-container"
        PORT = "8083"
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main',
                url: 'https://github.com/dipanjan-44/fleetcart'
            }
        }

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

        stage('Stop Old Container') {
            steps {
                bat 'docker stop %CONTAINER_NAME% || exit 0'
                bat 'docker rm %CONTAINER_NAME% || exit 0'
            }
        }

        stage('Run New Container') {
            steps {
                bat 'docker run -d -p %PORT%:8080 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }
    }
}