pipeline {
    agent any
    stages {
        stage('Build') {
            withMaven(
                // Maven installation declared in the Jenkins "Global Tool Configuration"
                maven: 'M3'
            ) {
                // Run the maven build
                sh "mvn clean install"
            } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs reports
        }
    }
}