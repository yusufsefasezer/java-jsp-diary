FROM tomcat:8.5
COPY target\java-jsp-diary.war /usr/local/tomcat/webapps/
