pipeline {
    agent any
    tools { 
        maven 'Maven-3.5.0' 
        jdk 'Java - 1.8.0_141' 
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn clean install"
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}