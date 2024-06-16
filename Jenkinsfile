
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
                sh 'javac -encoding UTF-8 -d classes src/*.java'
            }
        }

        stage('Test') {
            steps {
                script {
                    def os = isUnix() ? 'Unix' : 'Windows'
                    def classpath = os == 'Unix' ? 'classes:lib/:path/to/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar' : 'classes;lib/;path/to/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar'
                    def command = os == 'Unix' ? "java -cp $classpath org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt" : "java -cp $classpath org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt"
                    if (os == 'Unix') {
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
