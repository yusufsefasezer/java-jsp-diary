pipeline {

    agent any
    
    tools {
        maven 'maven 3.9.6'
    }
    
    stages {
        
        stage('Clone') {
            steps {
                git branch: 'docker', url: 'https://github.com/Berly01/java-jsp-diary.git'
            }
        }
         
        stage('Build') {
            steps {
                bat 'mvn package -Dmaven.test.skip'
            }
        }
        
        stage('SonarQube') {
            steps {
                withSonarQubeEnv('sonarQube') {
                    bat 'mvn verify sonar:sonar -Dmaven.test.skip'
                }
            }
        }
  
        stage('Build Docker Network') {
            steps {
                bat 'docker network create my-network'
            }
        }
     
        stage('Build Docker DataBase Image') {
            steps {
                bat 'docker build -f Dockerfile.db -t berly01/db-java-jsp-diary:latest .'
            }
        }
        
        stage('Run Docker DataBase Image') {
            steps {           
				bat 'docker run -d --name mysql-container --network my-network -p 3306:3306 berly01/db-java-jsp-diary'            
            }
        }
         
        stage('Docker Build Project Image ') {
            steps {
                bat 'docker build -f Dockerfile.tc -t berly01/java-jsp-diary:latest .'
            }
        }
        
        stage('Docker Run Project Image') {
            steps {        	
                bat 'docker run -d --name jspDiary-container --network my-network -p 8080:8080 berly01/java-jsp-diary'
            }
        }
        
        stage('Wait') {
			steps {
				script {
					sleep time: 8, unit: 'SECONDS'
				}
            }
		}
        
        stage('Junit and Selenium Test') {
            steps {
                bat 'mvn test'             
                bat 'mvn surefire-report:report -Dmaven.test.skip'             
            }
        }      
              
        stage('DockerHub Login') {
            steps {
                
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                  bat 'echo docker login -u ${USERNAME} -p ${PASSWORD} docker.io'
                }
                
            }
        }
        
        stage('Push image to hub') {
            steps {
                bat 'docker push berly01/java-jsp-diary'
            }
        }         
    }
       
    post {     
       
        always { 
            bat 'docker logout'
    	}
               
        failure {
            echo 'Alguna prueba falló. Deteniendo el flujo...'
        }
    }
}