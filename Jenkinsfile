pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish Allure Report') {
            steps {
                allure(
                    includeProperties: false,
                    results: [[path: 'allure-results']]
                )
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'screenshots/**/*.*', allowEmptyArchive: true
        }

        success {
            echo 'Automation execution completed successfully'
        }

        failure {
            echo 'Automation execution failed'
        }
    }
}