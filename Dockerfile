FROM tomcat:8.5
COPY C:\Users\USUARIO\.jenkins\workspace\branch_berly\target\java-jsp-diary.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]