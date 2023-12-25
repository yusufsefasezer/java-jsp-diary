
FROM mysql:latest
ENV MYSQL_PASSWORD matafurros9000 
ENV MYSQL_USER root
ENV MYSQL_DATABASE jspDiary
COPY db-java-jsp-diary.sql /docker-entrypoint-initdb.d/
EXPOSE 3306


FROM tomcat:8.5
COPY /target/java-jsp-diary.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]