pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {

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

            junit 'target/surefire-reports/*.xml'

            archiveArtifacts(
                artifacts: 'screenshots/**/*.*',
                allowEmptyArchive: true
            )
        }

        success {
            echo '✅ Automation execution completed successfully'
        }

        failure {
            echo '❌ Automation execution failed'
        }

        unstable {
            echo '⚠️ Automation execution completed with warnings'
        }
    }
}