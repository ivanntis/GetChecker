Extension para BurpSuite:

Para cada request que tenga parámetros por POST enviar un segundo request GET con los mismos parámetros en el body de la petición e informando de un issue en caso que el resultado del POST sea código HTTP 20X


Pre-requisitos

- SDK Java 17
- Gradle

Comiplar:

Abre una temrinal y corre los siguiente comando:

gradle build 
gralde jar

Instalar extension 

1) Abrir brup suite 
2) menu:extensions -> 
3) Ir seccion Burp extension click add.
4) Se Abre popup Load Burp extensions 
5) Ir seccion Extension detail 
6) Extension type JAVA
7) Seleccione el jar 
8) DirProject/build/libs/GetChecker-xxxxxx.js



