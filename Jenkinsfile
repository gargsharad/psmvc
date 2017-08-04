pipeline {
    agent any
    tools { 
        maven 'Maven-3.5.0' 
        jdk 'Java - 1.8.0_141' 
    }
    stages {
        stage('Pre Build') {
            steps{
                sh 'git log -1 > GIT_LOG'
            }
            def git_log = readFile 'GIT_LOG'
            if (git_log.contains('[maven-release-plugin]')) {
                currentBuild.result = 'ABORTED'
                return
            }
        }
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