pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Compile the Java code with JUnit 5 dependencies
                sh '''
                    mkdir -p classes
                    javac -encoding UTF-8 -d classes -cp "lib/junit-platform-console-standalone-1.7.1.jar:lib/junit-jupiter-api-5.7.1.jar:lib/junit-jupiter-engine-5.7.1.jar" src/BookManager.java src/BookManagerTest.java
                '''
            }
        }

        stage('Test') {
            steps {
                script {
                    def classpath = "classes:lib/junit-platform-console-standalone-1.7.1.jar:lib/junit-jupiter-api-5.7.1.jar:lib/junit-jupiter-engine-5.7.1.jar"
                    def command = isUnix() ? "java -cp $classpath org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt" : "java -cp $classpath org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt"
                    if (isUnix()) {
                        sh command
                    } else {
                        bat command
                    }
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts 'test_results.txt'
        }
        failure {
            echo 'Build or test failed'
        }
        success {
            echo 'Build and test succeeded'
        }
    }
}

