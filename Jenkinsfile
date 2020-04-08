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
        stage('Run SpringBoot') {
	        steps {
               	sh 'mvn spring-boot:run &'
            }
        }
        stage('Testing Stage') {
            steps {
              	sh 'mvn test'
            }
        }
    }	
}