FROM mysql:latest
COPY db-java-jsp-diary.sql /docker-entrypoint-initdb.d/



FROM tomcat:8.5
COPY /target/java-jsp-diary.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]