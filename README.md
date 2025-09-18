# Spring Boot JWT Microservices Example

This project demonstrates a microservices architecture using Spring Boot, with JWT (JSON Web Token) authentication. It is organized into several independent services, each with a specific responsibility, and showcases best practices for secure, scalable, and maintainable microservices development in Java.

## Project Structure

- **gateway-service/**: API Gateway that routes requests to the appropriate microservices and handles JWT authentication/authorization.
- **identity-service/**: Handles user authentication, registration, and JWT token issuance. Responsible for user management and security.
- **demo-service/**: Example microservice that exposes protected endpoints, accessible only with a valid JWT.
- **common-lib/**: Shared library containing common code, utilities, and models used across services.

## Features

- **Spring Boot**: Rapid development with production-ready defaults.
- **JWT Authentication**: Secure stateless authentication across services.
- **API Gateway**: Centralized entry point for all client requests, with routing and security.
- **Service Isolation**: Each service is independently deployable and scalable.
- **Gradle Multi-Module**: Modular build setup for easy dependency management.

## How It Works

1. **User Registration & Login**: Users register and log in via the `identity-service`. Upon successful authentication, a JWT is issued.
2. **Token Usage**: The client includes the JWT in the `Authorization` header for subsequent requests.
3. **Gateway Validation**: The `gateway-service` validates the JWT and forwards requests to the appropriate microservice.
4. **Protected Resources**: Services like `demo-service` expose endpoints that require a valid JWT for access.

## Getting Started


### Prerequisites
- Java 17 or higher (for local builds)
- Docker & Docker Compose


### Build the Project

To build all services and Docker images:

```bash
./gradlew build
docker-compose build
```

### Run All Services with Docker Compose

Start all services using Docker Compose:

```bash
docker-compose up
```

This will build and run the `gateway-service`, `identity-service`, and `demo-service` containers. Each service will be available on the following ports:

- Gateway Service: [http://localhost:8080](http://localhost:8080)
- Identity Service: [http://localhost:8081](http://localhost:8081)
- Demo Service: [http://localhost:8082](http://localhost:8082)

To stop the services, press `Ctrl+C` and run:

```bash
docker-compose down
```

### Endpoints Overview

- **Identity Service**
  - `POST /auth/register` — Register a new user
  - `POST /auth/login` — Authenticate and receive JWT
- **Demo Service**
  - `GET /demo/info` — Protected endpoint (requires JWT)
- **Gateway Service**
  - Routes all requests and enforces authentication


## Configuration

Each service has its own `application.yml` for configuration. Update database, port, and JWT secret settings as needed.

## Development (Optional)

You can still run services locally for development using Gradle:

```bash
./gradlew :gateway-service:bootRun
./gradlew :identity-service:bootRun
./gradlew :demo-service:bootRun
```

