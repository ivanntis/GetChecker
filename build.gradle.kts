plugins {
    id("java")
    application // Agregar el plugin de aplicación

}

group = "org.websec"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("net.portswigger.burp.extensions:montoya-api:2024.7")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}

application {
    mainClass.set("org.websec.BurpExtensionChecker") // Define la clase principal
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.test {
    useJUnitPlatform()
}