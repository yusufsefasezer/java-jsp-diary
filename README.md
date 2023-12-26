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

## Índice

1. [IDE y Lenguaje](#ide-y-lenguaje)
2. [SonarLint como extensión de Eclipse](#sonarlint-como-extensión-de-eclipse)
3. [Reiniciar](#reiniciar)
4. [Refactorización](#refactorización)
   1. [Archivo: DiaryRepository.java](#archivo-diaryrepositoryjava)
   2. [Archivo: UserRepository.java](#archivo-userrepositoryjava)
   3. [Archivo: Helper.java](#archivo-helperjava)
5. [Commit y Push](#commit-y-push)
6. [Pruebas Unitarias (JUnit)](#pruebas-unitarias-junit)
7. [Lenguaje Ubicuo](#lenguaje-ubicuo)
   1. [Modelo (Package com.yusufsezer.model)](#modelo-package-comyusufsezermodel)
   2. [Repositorios (Package com.yusufsezer.repository)](#repositorios-package-comyusufsezerrepository)
   3. [Interfaz de Base de Datos (Package com.yusufsezer.contracts)](#interfaz-de-base-de-datos-package-comyusufsezercontracts)
   4. [Implementación de Base de Datos MySQL (Package com.yusufsezer.repository)](#implementación-de-base-de-datos-mysql-package-comyusufsezerrepository)
   5. [Modelo de dominio de la aplicación monolítica](#modelo-de-dominio-de-la-aplicación-monolítica)
      1. [Entidades Principales](#entidades-principales)
         - [User (Usuario)](#user-usuario)
         - [Diary (Diario)](#diary-diario)
      2. [Reglas de Negocio Potenciales](#reglas-de-negocio-potenciales)
   6. [Estructura de la aplicación monolítica - dominio](#estructura-de-la-aplicación-monolítica---dominio)
      - [Funcionalidades Principales](#funcionalidades-principales)
      - [Aspectos a Considerar](#aspectos-a-considerar)
   7. [Módulos](#módulos)
      - [Módulo de Usuarios](#módulo-de-usuarios)
      - [Módulo de Diarios](#módulo-de-diarios)
      - [Módulo de Conexión a la Base de Datos](#módulo-de-conexión-a-la-base-de-datos)
      - [Módulo de Seguridad](#módulo-de-seguridad)
      - [Módulo de Validación de Datos y Manejo de Errores](#módulo-de-validación-de-datos-y-manejo-de-errores)


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

## Modelo de dominio de la aplicación monolítica

### Entidades Principales:
#### User (Usuario):

- Atributos:
  - id: Identificador único del usuario.
  - firstName: Nombre del usuario.
  - lastName: Apellido del usuario.
  - email: Dirección de correo electrónico del usuario.
  - password: Contraseña del usuario.
- Relaciones: No se indican relaciones directas en el fragmento, pero probablemente tenga relaciones con los diarios, como un usuario tiene muchos diarios.
  
#### Diary (Diario):

- Atributos:
  - id: Identificador único del diario.
  - userId: Identificador del usuario al que pertenece el diario.
  - dateOfDiary: Fecha del diario.
  - content: Contenido del diario.
  - visibility: Visibilidad del diario (puede ser público o privado).
-Relaciones: Pertenece a un usuario. Tiene una relación de uno a muchos con las entradas del diario de un usuario.

### Reglas de Negocio Potenciales:

- Autenticación y Autorización:
  - Verificación de credenciales de usuario para el inicio de sesión.
  - Control de acceso basado en roles o permisos.
- Gestión de Diarios:
  - Crear, leer, actualizar y eliminar (CRUD) diarios para un usuario específico.
  - Control de la visibilidad de los diarios (públicos o privados).
- Relaciones Usuario-Diario:
  - Establecer relaciones de pertenencia entre los diarios y los usuarios.
  - Garantizar que los diarios se asocien correctamente con el usuario propietario.
- Validación de Datos:
  - Validar la integridad de los datos ingresados, como direcciones de correo electrónico válidas, contraseñas seguras, etc.
- Seguridad:
  - Encriptación de contraseñas almacenadas en la base de datos.
  - Protección contra ataques de inyección SQL u otras vulnerabilidades de seguridad.

 ## Estructura de la aplicación monolítica - dominio

 Las principales funcionalidades identificadas en esta estructura son:

### Funcionalidades Principales:

- Gestión de Usuarios:
  - Crear Usuarios: La aplicación puede crear nuevos usuarios almacenando su información en la base de datos.
  - Obtener Usuarios: Recuperar información de usuarios existentes de la base de datos.
  - Actualizar Usuarios: Modificar información de usuarios existentes.
  - Eliminar Usuarios: Eliminar usuarios de la base de datos.
- Gestión de Diarios:
  - Crear Diarios: Crear nuevas entradas de diario y asociarlas con un usuario.
  - Obtener Diarios: Recuperar diarios existentes basados en ciertos criterios, como usuario específico o visibilidad.
  - Actualizar Diarios: Modificar contenido, visibilidad o fecha de los diarios existentes.
  - Eliminar Diarios: Eliminar entradas de diario.
- Autenticación y Seguridad:
  - Inicio de Sesión: Verificar credenciales de usuario para permitir el acceso a la aplicación.
  - Protección de Datos: Encriptar contraseñas almacenadas y validar la integridad de los datos ingresados para mitigar riesgos de seguridad.
- Conexión a la Base de Datos:
  - Conectar a MySQL: Establecer una conexión con la base de datos MySQL.
  - Ejecutar Consultas SQL: Realizar operaciones de consulta, actualización, inserción y eliminación en la base de datos utilizando sentencias SQL.
- Manipulación de Modelos:
  - Creación y Actualización de Modelos: Instanciar y modificar objetos User y Diary para reflejar los datos almacenados en la base de datos.
- Validación de Datos y Control de Errores:
  
### Aspectos a Considerar:

- Arquitectura Monolítica: La aplicación parece seguir un enfoque monolítico, lo que significa que todas estas funcionalidades están integradas dentro de una sola aplicación, lo que puede hacer que el mantenimiento y la escalabilidad sean más desafiantes a medida que la aplicación crece.
- Patrón de Repositorio: La estructura está organizada utilizando un patrón de repositorio para separar la lógica de acceso a datos de la lógica de negocio, lo que permite una mejor modularidad y mantenibilidad.
- Seguridad y Manejo de Contraseñas: La aplicación utiliza una capa de seguridad para encriptar las contraseñas almacenadas en la base de datos, lo que es una buena práctica de seguridad.

## Modulos

### Módulo de Usuarios:

- Funcionalidades:
  - Creación, lectura, actualización y eliminación de usuarios.
  - Autenticación de usuarios.
- Lenguaje Ubicuo: UserManagementModule, UserAuthenticationModule
  
#### Módulo de Diarios:

- Funcionalidades:
  - Gestión de entradas de diario (crear, leer, actualizar, eliminar).
  - Obtener diarios basados en criterios específicos (usuario, visibilidad).
- Lenguaje Ubicuo: DiaryManagementModule
  
### Módulo de Conexión a la Base de Datos:

- Funcionalidades:
  - Establecer conexión con MySQL.
  - Ejecutar consultas SQL.
- Lenguaje Ubicuo: DatabaseConnectionModule
  
### Módulo de Seguridad:

- Funcionalidades:
  - Verificar credenciales de inicio de sesión.
  - Encriptar y manejar contraseñas de usuarios.
- Lenguaje Ubicuo: SecurityModule
  
### Módulo de Validación de Datos y Manejo de Errores:

- Funcionalidades:
  - Validar datos de entrada.
  - Manejar excepciones y errores.
- Lenguaje Ubicuo: DataValidationModule, ErrorHandlingModule
  
Aplicar el lenguaje ubicuo implica nombrar los módulos de manera que su propósito sea claro y comprensible para cualquier persona que trabaje en el proyecto. Los nombres deben reflejar la funcionalidad del módulo sin entrar en detalles de implementación específicos.

Por ejemplo, se utilizan términos generales como "UserManagementModule" para indicar el manejo de usuarios y sus operaciones, "DiaryManagementModule" para el manejo de diarios y sus operaciones.

