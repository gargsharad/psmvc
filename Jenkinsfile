pipeline {
    agent any
    tools { 
        maven 'Maven-3.5.0' 
        jdk 'Java - 1.8.0_141' 
    } 
    stages {
        stage('Build') { 
            steps {
                sh "mvn versions:set -DnewVersion=${env.BUILD_NUMBER} clean install"
            }
            post {
                success {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Deploy'){
            agent {
                label 'apache'
            }
            steps{
                sh "cp target/psmvc-1.war /var/www/html/psmvc/all/" 
            }
        }   
    }
}