# Utilizează o imagine oficială Java 17
FROM openjdk:17-jdk-alpine

# Copiază fișierul JAR al microserviciului în container
COPY target/album-shop-service-0.0.1-SNAPSHOT.jar /app/album-shop-service.jar

# Definirea comenzii care va porni microserviciul când containerul va fi rulat
CMD ["java", "-jar", "/app/album-shop-service.jar"]