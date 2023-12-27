
## Demostracion del pipeline:
https://drive.google.com/file/d/1RNFcoKqlyDMJu9E7WXOmUvKuAIoeBYre/view?usp=sharing


## Solucionando errores de mantenibilidad en LoginServlet.java y RegisterServlet.java:

![bandicam 2023-12-26 22-33-15-038](https://github.com/Berly01/java-jsp-diary/assets/104176510/18328425-5460-4ef2-8d4f-06f5104d8abd)
![bandicam 2023-12-26 22-33-39-434](https://github.com/Berly01/java-jsp-diary/assets/104176510/2bc7c3c8-6bff-4f7a-9f34-232cdf96c035)


## Códigos originales(se repite la misma linea 3 veces, se recomienda usar variables):

![login](https://github.com/Berly01/java-jsp-diary/assets/104176510/ea4140e0-7250-4ac3-9989-50af88faa18e)
![register](https://github.com/Berly01/java-jsp-diary/assets/104176510/fe043bc5-6c48-4c12-882d-a8e87ceca0aa)


## Mejora/corrección(textos planos reemplazados por nuevas variables/constantes):

![updated_login](https://github.com/Berly01/java-jsp-diary/assets/104176510/a4f5c8c7-6718-409a-85c6-81c8a67bbf72)
![updated_register](https://github.com/Berly01/java-jsp-diary/assets/104176510/eb624c47-f16b-4bb8-9459-e3939728c246)
=======


=======
# Java JSP Diary - Reporte de Sonarlint:

## Clase UserRepository.java
Podemos apreciar que el codigo esta duplicando varios valores mas de 3 veces, sugiriendonos reemplazarlo con una constante en su lugar.

![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/c69d37c5-a781-4737-81d7-53206d2b008b)

## Bloque de codigo en cuestion:
Similares a estos, donde se ve lo detallado en el reporte:

![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/ecd7c13d-4ddc-4f88-ac63-4ff8d7bbbc46)
=======
# Diario JSP de Java
Una sencilla aplicación de diario MySQL desarrollada con Java EE JSP.

Este proyecto se desarrolló con Java EE Servlet, JSP, Maven, MySQL.

## [Descargar](https://github.com/yusufsefasezer/java-jsp-diary/archive/master.zip)

## Ejecutar programa

Puede ejecutar esta aplicación a continuación con el comando Tomcat sin la instalación de Tomcat.


## Correcion:
Creamos las constantes para usarlas en los demas bloques de codigo:


![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/0bb741b9-a021-471e-8696-f6a7538c366a)

Los colocamos en las funciones correspondientes (las demas son similares):
=======
**NOTA:** Debes asegurarte de que Maven esté instalado.

## Capturas de pantallas


![image](https://github.com/Berly01/java-jsp-diary/assets/104027221/a5d9a80b-6f0a-469a-89a5-368c8235b54e)


=======
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

## Módulos

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

## Contextos delimitados para los modelos

estableciendo modelos con responsabilidades específicas dentro de cada contexto.

### Módulo de Usuarios:

Contexto delimitado: User Management
- Entidades:
   - User: Representa la entidad de usuario con atributos como id, firstName, lastName, email, password.
- Objetos de Valor:
   - Ninguno identificado en el contexto delimitado de Usuarios.
- Agregados:
   - Ninguno identificado en este contexto específico, ya que la entidad de usuario puede considerarse como una entidad independiente.
- Servicios de Dominio:
UserAuthService: Responsable de la autenticación de usuarios.
   - UserRepository: Encargado de la gestión de usuarios en la base de datos (CRUD operations).
   - UserValidator: Validación de datos relacionados con usuarios.

### Módulo de Diarios:

Contexto delimitado: Diary Management
- Entidades:
   - Diary: Representa la entidad de diario con atributos como id, userId, dateOfDiary, content, visibility.
- Objetos de Valor:
   - Ninguno identificado en este contexto específico.
- Agregados:
   - Ninguno identificado directamente, ya que la entidad de diario podría considerarse como independiente.
- Servicios de Dominio:
   - DiaryService: Gestiona las operaciones CRUD relacionadas con los diarios.
   - DiaryRepository: Maneja la persistencia de diarios en la base de datos.
   - DiaryVisibilityManager: Controla la visibilidad de los diarios.

### Módulo de Conexión a la Base de Datos:

Contexto delimitado: Database Connection
- Entidades:
   - No se consideran entidades en este contexto específico.
- Objetos de Valor:
   - No aplicable en este contexto.
- Agregados:
   - No se identifican agregados en este contexto.
- Servicios de Dominio:
   - DatabaseConnectionService: Establece y administra la conexión con la base de datos.
   - SQLQueryExecutor: Ejecuta consultas SQL en la base de datos.

### Módulo de Seguridad:

Contexto delimitado: Security
- Entidades:
   - No se consideran entidades en este contexto específico.
- Objetos de Valor:
   - No aplicable en este contexto.
- Agregados:
   - No se identifican agregados en este contexto.
- Servicios de Dominio:
   - EncryptionService: Maneja la encriptación y desencriptación de contraseñas.
   - AuthenticationService: Gestiona la autenticación de usuarios.

### Módulo de Validación de Datos y Manejo de Errores:

Contexto delimitado: Data Validation & Error Handling
- Entidades:
   - No se consideran entidades en este contexto específico.
- Objetos de Valor:
   - No aplicable en este contexto.
- Agregados:
   - No se identifican agregados en este contexto.
- Servicios de Dominio:
   - DataValidationService: Valida la integridad de los datos antes de su procesamiento.
   - ErrorHandlingService: Maneja la gestión y registro de errores en la aplicación.

Estos contextos delimitados representan áreas específicas dentro del dominio de la aplicación y establecen modelos con responsabilidades claras para cada uno de los módulos identificados, ayudando a mantener un diseño modular y una distribución clara de las responsabilidades dentro de la aplicación monolítica.

## Dependencias entre Módulos

### Módulo de Usuarios:

- Depende del módulo de Seguridad para la gestión de autenticación de usuarios.
- Podría depender del módulo de Diarios si hay relaciones establecidas entre usuarios y diarios.

### Módulo de Diarios:

- Puede depender del módulo de Usuarios para la gestión de la asociación entre usuarios y diarios.
- Depende del módulo de Conexión a la Base de Datos para persistir los diarios en la base de datos.

### Módulo de Conexión a la Base de Datos:

- Puede ser utilizado por todos los módulos para realizar operaciones en la base de datos.

### Módulo de Seguridad:

- Puede ser requerido por otros módulos para la autenticación de usuarios.

### Módulo de Validación de Datos y Manejo de Errores:

- Podría ser utilizado por otros módulos para validar datos antes de procesarlos.

## Refactorización a Microservicios:

Los contextos delimitados identificados podrían ser candidatos para ser refactorizados en microservicios. Sin embargo, la elección de convertirlos en microservicios debe considerar:

**Acoplamiento y Cohesión:** Evaluar qué módulos están altamente acoplados y cuáles pueden ser separados manteniendo la cohesión de las funcionalidades relacionadas.

**Límites de Dominio Claros:** Los límites del dominio deben ser sólidos y claros para cada microservicio. Si un módulo contiene múltiples responsabilidades no relacionadas, podría ser un candidato para la división.

**Comunicación y Dependencias:** Evaluar cómo se comunicarán los microservicios y gestionarán las dependencias entre ellos, como la necesidad de API, eventos, mensajería, etc.

En un enfoque de microservicios, cada contexto delimitado podría convertirse en un microservicio independiente, manteniendo su propia base de datos y lógica de negocio. Por ejemplo:

- **User Management:** Se convertiría en un microservicio encargado de la gestión de usuarios y la autenticación.
- **Diary Management:** Sería otro microservicio responsable de las operaciones de diarios.
- **Database Connection:** Podría ser una capa compartida o un servicio independiente que proporciona acceso a la base de datos a otros microservicios.
- **Security:** Podría ser un microservicio dedicado a la gestión de la seguridad y autenticación.

La refactorización en microservicios puede brindar beneficios en términos de escalabilidad, mantenibilidad y despliegue independiente, pero también introduce complejidad en la gestión de múltiples servicios y su interacción. Es crucial evaluar cuidadosamente los límites del dominio y las interacciones entre módulos antes de tomar decisiones de refactorización.

## Contextos delimitados

### User Management Microservice:

- Responsabilidades:
   - Gestión de usuarios: creación, lectura, actualización, eliminación (CRUD).
   - Autenticación de usuarios.
- Componentes:
   - UserAuthService: Lógica para la autenticación.
   - UserRepository: Capa para la persistencia de usuarios.
   - UserValidator: Validación de datos relacionados con usuarios.

### Diary Management Microservice:

- Responsabilidades:
   - Gestión de diarios: creación, lectura, actualización, eliminación (CRUD).
   - Control de visibilidad de diarios.
- Componentes:
   - DiaryService: Lógica para operaciones CRUD de diarios.
   - DiaryRepository: Capa para la persistencia de diarios.
   - DiaryVisibilityManager: Gestión de la visibilidad de los diarios.

### Database Access Microservice:

- Responsabilidades:
   - Manejar la conexión y acceso a la base de datos.
- Componentes:
   - DatabaseConnectionService: Establecimiento y gestión de conexiones.
   - SQLQueryExecutor: Ejecución de consultas SQL.

### Security Microservice:

- Responsabilidades:
   - Gestión de la seguridad, incluida la encriptación y autenticación.
- Componentes:
   - EncryptionService: Manejo de la encriptación y desencriptación de contraseñas.
   - AuthenticationService: Lógica para la autenticación de usuarios.

### Data Validation & Error Handling Microservice:

- Responsabilidades:
   - Validación de datos antes del procesamiento.
   - Manejo y registro de errores.
- Componentes:
   - DataValidationService: Validación de datos de entrada.
   - ErrorHandlingService: Gestión de errores y excepciones.
 
Estos microservicios se pueden diseñar y desplegar de manera independiente, cada uno con su propia lógica de negocio y base de datos. La comunicación entre ellos podría realizarse a través de API REST, mensajería, eventos, o algún otro mecanismo de comunicación.

La separación en microservicios permite la escalabilidad y mantenibilidad independiente de cada componente, pero también introduce la necesidad de gestionar la comunicación entre los servicios y las posibles implicaciones en términos de latencia y complejidad en el manejo de múltiples sistemas distribuidos.

