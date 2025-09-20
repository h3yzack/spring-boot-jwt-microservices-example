FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
COPY build/libs/gateway-service.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]