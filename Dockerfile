FROM mysql:latest
COPY db-java-jsp-diary.sql /docker-entrypoint-initdb.d/



