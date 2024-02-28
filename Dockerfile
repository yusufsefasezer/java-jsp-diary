# Stage 1: Maven Build
FROM maven AS build
WORKDIR /usr/src/app
COPY . .
RUN mvn clean package

# Stage 2: Tomcat Runtime
FROM tomcat
RUN ls .
COPY --from=build /usr/src/app/target/java-jsp-diary.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080

CMD ["catalina.sh", "run"]

