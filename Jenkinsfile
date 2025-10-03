// Jenkinsfile
pipeline {
    agent any

    tools {
        maven 'M3_HOME'
        jdk 'JDK-21'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the Spring Boot application with Maven...'
                sh 'mvn clean install -DskipTests'
            }
        }
        // Ajoutez les autres stages (Test, Deploy) si vous le souhaitez
    }
}