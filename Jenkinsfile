// Note: Jenkinsfiles are by default, regular text files

// Below, you can find the pipeline contents
pipeline {
    agent any
    stages {
        stage('Build') {  // Defines a formal stage in Jenkins called "Build"
            steps {
                sh 'mvn -B -DskipTests clean package' // Runs the Maven command to build Java applications without running tests
            }
        }
    }
}

