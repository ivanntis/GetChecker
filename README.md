**Extension BurpSuite:**

Para cada request que tenga parámetros por POST, enviar un segundo request GET con los mismos parámetros en el body de la petición e informar de un issue en caso de que el resultado del POST sea código HTTP 20X

**Pre-requisitos**

	•	SDK Java 17
	•	Gradle

**Compilar:**

1.	Clona el proyecto.
2.	Abre una terminal y corre los siguientes comandos en la carpeta principal del proyecto:

`gradle build`

`gradle jar`

**Instalar extensión**

	1.	Abrir Burp Suite
	2.	Menú: Extensions
	3.	Ir a la sección Burp Extension y hacer clic en add.
	4.	Se abre el popup Load Burp Extensions
	5.	Ir a la sección Extension Detail
	6.	Extension type: JAVA
	7.	Selecciona el jar
	8.	DirProject/build/libs/GetChecker-xxxxxx.jar

**Configura Burp Suite para evitar problemas con HTTPS:**

	•	Es importante agregar el certificado del navegador de prueba del Burp Suite en el keystore de la máquina para poder capturar el tráfico por la capa SSL.
	•	En MacBook, puedes abrir la aplicación Keychain Access.app
	•	Abre el navegador de preferencia e ingresa a http://burp.
	•	Haz clic en el enlace “CA Certificate”; esto descarga el archivo cacert.der
	•	En una terminal, ejecuta openssl x509 -inform der -in cacert.der -out cacert.pem para generar el formato del certificado.
	•	Carga el archivo pem generado en la sección de llaves del Keychain Access.app
	•	Abre el certificado cargado y en la sección de Trust o confianza, selecciona que confías en todo.

**Configura el proxy**

	•	En Burp Suite, ve al menú de proxy -> Proxy settings
	•	En el menú de Tools, agrega la IP y puerto del proxy 127.0.0.1:8080; normalmente ya está configurada.
	•	En el setting del navegador, busca la configuración de proxy.
	•	Activa el proxy HTTPS con la configuración de Burp Suite 127.0.0.1:8080

Ya tienes todo para que funcione.

Si tienes alguna duda, no te preocupes, puedes dejarme un mensaje en los issues de GitHub.

![img.png](docs/img.png)