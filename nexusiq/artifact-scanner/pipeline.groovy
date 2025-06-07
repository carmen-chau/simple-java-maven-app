pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker image from repo root..."
                    docker.build('my-custom-image', '../../')
                }
            }
        }

        stage('Run Container') {
            steps {
                script {
                    docker.image('my-custom-image').inside {
                        sh 'echo "Inside the custom Docker container!"'
                        sh 'python3 --version || echo "Python not found"'
                    }
                }
            }
        }
    }
}
