FROM eclipse-temurin:21-jdk-jammy

COPY --from=ghcr.io/ufoscout/docker-compose-wait:latest /wait /wait

WORKDIR /app
COPY build/libs/identity-service.jar app.jar

ENTRYPOINT /wait && exec java -jar /app/app.jar