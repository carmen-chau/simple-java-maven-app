pipeline {
    agent any

    stages {
        stage ("Test Stage") {
            steps {
                script {
                    echo "Hello World"
                }
            }
        }
    }
}