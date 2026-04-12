pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/dipanjan-44/fleetcart.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t fleetcart-app .'
            }
        }

        stage('Deploy Application') {
            steps {
                bat 'docker-compose down'
                bat 'docker-compose up -d --build'
            }
        }

    }
}
