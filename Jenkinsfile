// Note: Jenkinsfiles are by default, regular text files

// Below, you can find the deployment pipeline's content
pipeline {
    agent any // Execute this deployment pipeline on any available Jenkin node / job
//     triggers {
//             cron('''
//             TZ=Canada/Eastern
//              */5 * * * *
//             ''')  // 14:30 = 2:30 PM every day
//         }
    stages {

//         stage ('Debug Environment'){
//            steps{
//                 echo "The token value for SAMPLE_ENV_VARIABLE is: ${env.SAMPLE_ENV_VARIABLE ?: 'Not defined'}"
//                 echo "The token value for SAMPLE_NON_DEFINED_ENV_VARIABLE is: ${env.SAMPLE_NON_DEFINED_ENV_VARIABLE ?: 'Not defined'}"
//                 echo "Finished the debugging step"
//            }
//         }
        stage('Build') {  // Defines a formal stage in the pipeline called "Build"
            steps {
                sh 'mvn -B -DskipTests clean package' // Runs the Maven command to build Java applications without running tests
            }
        }

        stage ('Extract Metadata Content'){
            steps {
                script {
                    env.ARTIFACT_ID = sh(script: "mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout", returnStdout: true).trim()
                    env.VERSION = sh(script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true).trim()
                    env.JAR_FILE_PATH = "target/${env.ARTIFACT_ID}-${env.VERSION}.jar"

                    echo "[DEBUGGING] Artifact ID is: ${env.ARTIFACT_ID}"
                    echo "[DEBUGGING] Version is: ${env.VERSION}"
                    echo "[DEBUGGING] Jar file path is: ${env.JAR_FILE_PATH}"

                }
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

        stage('Deliver'){
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }

    post { // Normally, these steps would be running near the end of the pipeline execution

        success {
            echo 'Everything completed fine!'
        }


        failure {
              echo 'Pipeline failed. Please check the error logs (or scroll above) for more details.'
        }
    }
}

