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
        stage('Start SpringBoot Application') {
	        steps {
               	sh 'mvn spring-boot:run &'
            }
        }
        stage('Run UnitTests') {
            steps {
              	sh 'mvn test'
            }
        }
    }	
}