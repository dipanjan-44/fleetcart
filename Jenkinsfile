pipeline {

    agent any

    tools {

        maven 'Maven'

    }

    stages {

        stage('Checkout Code') {

            steps {

                git url: 'https://github.com/your-username/fleetcart.git'

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
                bat 'docker-compose up -d'

            }

        }

    }

}