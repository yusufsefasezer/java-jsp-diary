# Diario JSP de Java
Una sencilla aplicación de diario MySQL desarrollada con Java EE JSP.

Este proyecto se desarrolló con Java EE Servlet, JSP, Maven, MySQL.

## [Descargar](https://github.com/yusufsefasezer/java-jsp-diary/archive/master.zip)

## Ejecutar programa

Puede ejecutar esta aplicación a continuación con el comando Tomcat sin la instalación de Tomcat.

``
mvn tomcat7:run
``

**NOTA:** Debes asegurarte de que Maven esté instalado.

## Capturas de pantallas

- [Register](screenshot/register.png)
- [Login](screenshot/login.png)
- [Add](screenshot/add.png)
- [Diaries](screenshot/diaries.png)
- [Edit](screenshot/edit.png)
- [Detail](screenshot/detail.png)
- [Profile](screenshot/profile.png)
- [Home](screenshot/home.png)

# Licencia
Este proyecto está bajo la licencia MIT. Consulte el archivo [LICENCIA](LICENSE) para obtener más detalles.

Creado por [Yusuf SEZER](http://www.yusufsezer.com)

## IDE Y lenguaje
- IDE: Eclipse 
- lenguaje: Java

## SonarLint como extensión de Eclipse
[Descargar por Marketplace - Eclipse](https://marketplace.eclipse.org/content/sonarlint#screenshots) 

## Reiniciar

Una vez instalado, se reiniciará el Eclipse.
![Una vez instalado, se reiniciará el Eclipse.](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A1.png)

## Refactorización

- Clonar el proyecto de software a ser refactorizado del repositorio principal en GitHub
- Abrir el proyecto de software a ser refactorizado.
- Construir el proyecto: Si todo va bien, podrá ver los resultados de la compilación y los warnings en la ventana View/Problems de su IDE.

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A2.png)

### Archivo: DiaryRepository.java

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A4.png)

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A5.png)

### Archivo: UserRepository.java

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A6.png)

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A7.png)

### Archivo: Helper.java

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A8.png)

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A9.png)

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A10.png)

## Commit y push

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A11.png)

## Pruebas unitarias (Junit)

![](https://github.com/Berly01/java-jsp-diary/blob/Jhonatan/screenshot/screenshot%20-%20eclipse/A3.png)

## Lenguaje ubicuo

Los paquetes y clases que has proporcionado sugieren un patrón de diseño de repositorio para la interacción con entidades de usuario y diario, además de una implementación de base de datos MySQL.

El código se estructura en varios paquetes:

### Modelo (Package com.yusufsezer.model):

Contiene las clases User y Diary, que representan entidades de usuario y diario respectivamente. Cada clase tiene atributos que corresponden a las columnas de las tablas en la base de datos.

### Repositorios (Package com.yusufsezer.repository):

UserRepository y DiaryRepository son clases que implementan la interfaz IRepository. Estas clases se encargan de interactuar con la base de datos para realizar operaciones CRUD (crear, leer, actualizar, eliminar) en las entidades de usuario y diario.

### Interfaz de Base de Datos (Package com.yusufsezer.contracts):

Define los contratos IDatabase e IRepository que son implementados por las clases MySQL, UserRepository y DiaryRepository. Estos contratos proporcionan métodos genéricos para la manipulación de datos y la conexión a la base de datos.

### Implementación de Base de Datos MySQL (Package com.yusufsezer.repository):

La clase MySQL implementa la interfaz IDatabase y establece la conexión con una base de datos MySQL específica utilizando JDBC (Java Database Connectivity).
El código se organiza para permitir operaciones como obtener usuarios, diarios, agregar nuevos elementos, actualizar y eliminar registros en la base de datos MySQL utilizando sentencias SQL.
