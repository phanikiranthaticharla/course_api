pipeline {
    agent any
	tools {
        maven 'maven_3.6.3' 
    }
    stages {
        stage('Compile Stage') {
            steps {
              	sh 'mvn clean compile'
            }
        }
        stage('Testing Stage') {
            steps {
              	sh 'mvn test'
            }
        }
        stage('Deploying Stage') {
	        steps {
               	sh 'mvn deploy'
            }
        }
    }
}