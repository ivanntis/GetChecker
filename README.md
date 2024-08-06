**Extension para BurpSuite:**

Para cada request que tenga parámetros por POST enviar un segundo request GET con los mismos parámetros en el body de la petición e informando de un issue en caso que el resultado del POST sea código HTTP 20X


**Pre-requisitos**

- SDK Java 17
- Gradle

**Comiplar:**

1) clona el proyecto
2) Abre una temrinal y corre los siguiente comando en la carpeta principal del proyecto:

gradle build 
gralde jar

**Instalar extension** 

1) Abrir brup suite 
2) menu:extensions 
3) Ir seccion Burp extension click add.
4) Se Abre popup Load Burp extensions 
5) Ir seccion Extension detail 
6) Extension type JAVA
7) Seleccione el jar 
8) DirProject/build/libs/GetChecker-xxxxxx.js

**Configura Burp Suite para evitar problemas con HTTPS:**
 - Es importante agregar el certificado del navegador de prueba del Burp Suite en el keystore de la maquina para poder capturar el trafico por la capa SSL.
 - EN Mack book puedes abrir la aplicacion `Keychain Access.app`
 - Abre en navegador de preferencia e ingresa a http://burp.
 - Clic en el enlace “CA Certificate” este descarga el archivo `cacert.der`
 - en una terminal ejecuta `openssl x509 -inform der -in cacert.der -out cacert.pem` para generar el formato del certificado.
 - Carga el archivo pem generado en la sección de llaves del `keychain Access.app`
 - Abre el certificado cargado y en la seccion de Thrust o confinaza, selecciona que confias en todo.

**Configura el proxy**
- en Burp suite ve al menu de proxy -> proxy settings
- En el menu de Tools agrega la ip y puerto de l proxy `127.0.0.1:8080`, normalmente ya esta conigurada.
- En el setting del navegador buscar la confiuguración de proxy
- Activa el proxy https con la configuración de Burp Suite `127.0.0.1:8080`


Ya tiene todo para que funcione. 

Si tienes alguna duda no te  preocupes puedes dejarme un mensaje en lo issues de github