pipeline
{
	agent any

	stages
	{
		stage('Checkout') 
		{
			steps
			{
				chekcout scm
			}
		}

		stage('Build')
		{
			steps
			{
				sh 'javac -encoding UTF-8 -d classes Practice/src/**/*.java'
			}
		}

		stage('Test')
		{
			steps
			{
				def classpath = "classes;lib/; path/to/eclipse/plugins/junit-platform-console-standalone- 1.7.1.jar"

				bat 'java -cp classes;lib/; path/to/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar org.junit.platform.console.ConsoleLauncher --scan-classpath > test_results.txt'
			}
		}
	}

	post
	{
		always
		{
			archiveArtifacts 'test_results.txt'
		}
		failure 
		{ 
			echo 'Build or test failed' 
		}
        success 
		{
			echo 'Build and test succeeded'
		}
	}
}