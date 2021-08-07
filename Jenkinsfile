pipeline {
    agent any
    tools {
        maven "maven3.8.1"
        jdk "jdk16"
    }
    stages {
        stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Site') {
            steps {
                sh 'mvn site'
            }
        }
        stage('Sonar') {
           steps {
               sh 'mvn verify sonar:sonar -Dsonar.projectKey=arantzalemasurier_proyecto-semana3-maven -Dsonar.organization=arantzalemasurier -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=6f7f37e9eed63a88e90d8248815e8bae4eecf8c5 -Dsonar.branch.name=master'
           }
        }
    }
}