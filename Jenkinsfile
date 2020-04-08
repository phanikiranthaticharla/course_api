pipeline {
    agent any

    stages {

        tools {
            maven 'maven_3.6.3' 
        }

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