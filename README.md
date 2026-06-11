🚚 FleetCart Logistics Management System

A full-stack logistics management system developed using Java Servlet, JSP, JDBC, MySQL, Docker, Jenkins, GitHub, and Cloud Deployment. The application enables logistics companies to manage delivery orders, drivers, and shipment statuses through a centralized dashboard.

📌 Project Overview

FleetCart is a web-based logistics management platform designed to streamline transportation operations.

The system allows administrators to:

Create and manage delivery orders
Add and manage drivers
Update delivery status
Track pending deliveries
Monitor active drivers
View logistics statistics in real-time
Deploy applications using modern DevOps practices
🚀 Features
Order Management
Create new delivery orders
View all orders
Update order status
Delete orders
Search orders
Driver Management
Add drivers
View available drivers
Delete drivers
Manage driver records
Dashboard
Total Orders Counter
Active Drivers Counter
Pending Deliveries Counter
User Interface
Responsive JSP-based UI
Navigation Bar
Success/Error Notifications
Animated Message Fade-Out
Dashboard Statistics Cards
🏗️ System Architecture
Browser
   │
   ▼
JSP Pages
   │
   ▼
Servlets
   │
   ▼
DAO Layer
   │
   ▼
JDBC
   │
   ▼
MySQL Database
🛠️ Technologies Used
Backend
Java 17
Java Servlets
JSP (Java Server Pages)
JDBC
Frontend
HTML
CSS
JavaScript
Database
MySQL
Build Tool
Maven
Version Control
Git
GitHub
Containerization
Docker
CI/CD
Jenkins
Cloud Deployment
Render
Railway MySQL
📂 Project Structure
fleetcart/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/fleetcart/
│       │       ├── dao/
│       │       ├── model/
│       │       ├── servlet/
│       │       └── util/
│       │
│       └── webapp/
│           ├── dashboard.jsp
│           ├── create-order.jsp
│           ├── drivers.jsp
│           ├── login.jsp
│           └── style.css
│
├── Dockerfile
├── docker-compose.yml
├── Jenkinsfile
├── pom.xml
└── README.md
🗄️ Database Schema
Orders Table
CREATE TABLE orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100),
    pickup_location VARCHAR(255),
    delivery_location VARCHAR(255),
    status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
Drivers Table
CREATE TABLE drivers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_name VARCHAR(100),
    phone VARCHAR(20),
    vehicle_number VARCHAR(50)
);
🐳 Docker Implementation

Docker was used to containerize the application and ensure consistent execution across environments.

Dockerfile
FROM tomcat:9.0

COPY target/fleetcart.war \
/usr/local/tomcat/webapps/

EXPOSE 8080
Benefits
Consistent deployment
Environment independence
Easy portability
Faster setup
🔄 Jenkins CI/CD Pipeline

Jenkins automates the build and deployment process.

Pipeline Workflow
GitHub Push
      │
      ▼
 Jenkins
      │
      ▼
 Maven Build
      │
      ▼
 Create WAR
      │
      ▼
 Docker Build
      │
      ▼
 Deploy
Jenkinsfile
pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t fleetcart-app .'
            }
        }

    }
}
CI/CD Benefits
Automated builds
Reduced manual deployment
Continuous Integration
Faster software delivery
☁️ Cloud Deployment
Application Hosting

Platform:

Render

Purpose:

Deploy FleetCart application online

Features:

Automatic deployments
GitHub integration
Free SSL
Public URL generation
Database Hosting

Platform:

Railway MySQL

Purpose:

Host production database

Features:

Managed MySQL
Cloud storage
Public connectivity
Secure credentials management
🔐 Environment Variables

The application uses environment variables for production deployment.

DB_URL=
DB_USERNAME=
DB_PASSWORD=

Benefits:

Secure credential management
No hardcoded passwords
Easier deployment
📸 Screenshots
Dashboard
Orders Overview
Driver Statistics
Pending Deliveries
Driver Management
Add Driver Form
Driver Listing
Jenkins Build
Successful Build Pipeline
Docker
Docker Image Creation
Running Container
Cloud Deployment
Render Live Application
📈 Future Enhancements
User Authentication
Role-Based Access Control
Driver Assignment Module
Shipment Tracking with Maps
REST API Integration
Email Notifications
SMS Alerts
Analytics Dashboard
Kubernetes Deployment
Monitoring using Prometheus & Grafana
🎯 Learning Outcomes

Through this project, the following concepts were implemented:

Java Development
Servlets
JSP
JDBC
MVC Architecture
Database Management
SQL Queries
CRUD Operations
MySQL Integration
DevOps
Git Version Control
GitHub Repository Management
Docker Containerization
Jenkins CI/CD Automation
Cloud Deployment
Environment Variable Configuration
Software Engineering
Layered Architecture
Code Reusability
Deployment Automation
Production Configuration
👨‍💻 Author

Dipanjan Chakraborty

B.Tech Computer Science Engineering
Lovely Professional University

Skills
Java
Spring Boot
SQL
Docker
Jenkins
AWS
DevOps
Full Stack Development
⭐ Project Highlights

✅ Java Servlet Based Application
✅ MySQL Database Integration
✅ Dockerized Deployment
✅ Jenkins CI/CD Pipeline
✅ GitHub Version Control
✅ Cloud Hosted on Render
✅ Railway Managed Database
✅ End-to-End DevOps Workflow
