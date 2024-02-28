# Java JSP Diary

A simple MySQL diary application developed with Java/Jakarta EE JSP.

This project developed with Jakarta EE Servlet, JSP, Maven, MySQL.

## [Download](https://github.com/yusufsefasezer/java-jsp-diary/archive/master.zip)

## How to run

### Maven

Maven must be installed to compile this application.

You can use the following commands to generate a WAR file.

```
mvn package
```

Once compiled, You can install the WAR in Tomcat.

**NOTE:** Tomcat version 10+ is required.

## Docker

**Docker must be installed.**

Build the Docker image with the tag "java-jsp-diary"

```
docker build -t java-jsp-diary .
```

```
docker run -p 80:8080 java-jsp-diary
```

You can access the application using `localhost:80` in your web browser.

## Docker Compose

**Docker must be installed.**

You can run the following commands to run both App and MySQL.

```
docker compose up
```

You can access the application using `localhost:80` in your web browser.

## Screenshot

- [Register](screenshot/register.png)
- [Login](screenshot/login.png)
- [Add](screenshot/add.png)
- [Diaries](screenshot/diaries.png)
- [Edit](screenshot/edit.png)
- [Detail](screenshot/detail.png)
- [Profile](screenshot/profile.png)
- [Home](screenshot/home.png)

# License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details

Created by [Yusuf Sezer](https://www.yusufsezer.com)
