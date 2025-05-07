// Note: Jenkinsfiles are by default, regular text files

// Below, you can find the deployment pipeline's content
pipeline {
    agent any // Execute this deployment pipeline on any available Jenkin node / job
    stages {
        stage('Build') {  // Defines a formal stage in the pipeline called "Build"
            steps {
                sh 'mvn -B -DskipTests clean package' // Runs the Maven command to build Java applications without running tests
            }
        }
        stage('Test'){ // Defines another formal stage in the pipeline called Test
            steps {
                sh 'mvn test' // Executes a Maven command that runs all the unit tests 
            }
            post { // A "post" section of a pipeline defines steps that would run after this particular stage of the pipeline
                   // In this case, this refers to what we would do after the "Test" stage
                always { 
                    junit 'target/surefire-reports/*.xml' // Archives xml results and displays it in the pipeline. 
                }
            }
        }
    }
}

