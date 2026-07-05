pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean Project') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'screenshots/**/*.*', allowEmptyArchive: true
        }

        success {
            echo 'Automation Execution Successful'
        }

        failure {
            echo 'Automation Execution Failed'
        }
    }
}