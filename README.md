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
- Java 17 or higher
- Gradle (wrapper included)

### Build the Project

```bash
./gradlew build
```

### Run Services
You can run each service individually:

```bash
./gradlew :gateway-service:bootRun
./gradlew :identity-service:bootRun
./gradlew :demo-service:bootRun
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

