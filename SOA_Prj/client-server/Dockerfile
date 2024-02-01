# Utilizează o imagine oficială Java 17
FROM openjdk:17-jdk-alpine

# Copiază fișierul JAR al microserviciului în container
COPY target/client-server-0.0.1-SNAPSHOT.jar /app/client-server.jar

# Definirea comenzii care va porni microserviciul când containerul va fi rulat
CMD ["java", "-jar", "/app/client-server.jar"]
