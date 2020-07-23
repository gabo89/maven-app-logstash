pipeline {
   agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }

    stages {

        stage('dependecy') {
            steps {
                echo 'Dependency..'
                  sh 'mvn dependency:tree'
            }
        }

        stage('Build') {
            steps {
                echo 'Building..'
		  sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
		 sh 'mvn test'
            }	
	    post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
      	stage('Deliver') {
            steps {
                echo 'starting app....'
		sh 'mvn spring-boot:run'
            }
        }
    }
}
