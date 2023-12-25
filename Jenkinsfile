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
        
        stage('Code Checkout') {
            
            steps {
                checkout scmGit(branches: [[name: '*/docker']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Berly01/java-jsp-diary.git']])
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean compile install -Dmaven.test.skip'
            }
        }
        
        /*
        stage('SonarQube') {
            steps {
                withSonarQubeEnv('sonarQube') {
                    bat 'mvn verify sonar:sonar -Dmaven.test.skip'
                }
            }
        }
        */
        
        stage('Build Docker Network') {
            steps {
                bat 'docker network create my-network'
            }
        }
     
        stage('Build Docker DataBase Image') {
            steps {
                bat 'docker build -f Dockerfile.db -t db-java-jsp-diary .'
            }
        }
        
        stage('Run Docker DataBase Image') {
            steps {           
            	withCredentials([string(credentialsId: 'con-mysql', variable: 'c-mysql-psw')]) {
				    bat 'docker run -itd --name mysql-container --network my-network -e MYSQL_ROOT_PASSWORD=${c-mysql-psw} -p 3307:3306 db-java-jsp-diary'
				}             
            }
        }
            
        stage('Docker Build Project Image ') {
            steps {
                bat 'docker build -f Dockerfile.tc -t java-jsp-diary .'
            }
        }
        
        stage('Docker Run Project Image') {
            steps {        	
                bat 'docker run -itd --name jspDiary-container --network my-network -p 8080:8080 java-jsp-diary'
            }
        }

		/*
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        */
    }
    
    post {        
        /*
        always {
    	    bat 'mvn surefire-report:report'
            bat 'docker logout'
            bat 'docker network rm my-network'
    	}
        */
        failure {
            echo 'Alguna prueba falló. Deteniendo el flujo...'
        }
    }
}