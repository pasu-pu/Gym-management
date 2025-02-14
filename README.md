# Gym Management System

This repository contains the backend solution for the Gym Management System project. It demonstrates a distributed system developed using Java and gRPC with a Hexagonal Architecture. The system includes an API, business logic, and persistence components based on Hibernate (JPA) and supports CRUD operations with filtering, paging, and a 1-to-many relationship between entities.

---

## Overview

The system is structured into the following layers:
- **Domain Layer:** Contains the core entities: Member, Trainer, Course, and Booking. Each entity uses the Builder Pattern and is annotated with JPA annotations.
- **Business Logic Layer:** Implements domain rules via classes such as MemberLogic, TrainerLogic, CourseLogic, and BookingLogic.
- **Infrastructure Layer:** Contains repository interfaces and their implementations (e.g., MemberRepository, TrainerRepository) that handle CRUD operations via Hibernate. It also includes configuration files (e.g., Hibernate configuration).
- **API Layer (gRPC):** Provides the external interface defined by Protocol Buffers. Adapter classes (e.g., MemberServiceImpl, TrainerServiceImpl) map gRPC messages to domain objects and vice versa.

---

## Prerequisites

- Java (JDK 17/21)
- Maven
- Docker (recommended)

---

## How to Run the System

### Option 1: Integrated Docker via Maven

The preferred solution integrates Docker into the Maven build process. To build, test, and run the system, simply execute:

```bash
mvn verify
```

This command will:
- Compile the source code.
- Run all unit tests.
- Build and start a Docker container with the application.
- Execute integration tests against the running system.

### Option 2: Manual Docker Startup

If Docker is not integrated into your Maven build, follow these steps:

1. **Build the project:**

   ```bash
   mvn clean package
   ```

2. **Build the Docker image:**

   ```bash
   docker build -t gym-management .
   ```

3. **Run the Docker container:**

   ```bash
   docker run -p 8080:8080 gym-management
   ```

---

## How to Execute Tests

### Unit Tests

Unit tests are executed as part of the Maven build lifecycle. To run them separately, use:

```bash
mvn test
```

### Integration Tests

Integration tests are also executed during the Maven build when running:

```bash
mvn verify
```

This command starts the application (via Docker if configured) and runs all integration tests.

---

## Additional Information

- **Hexagonal Architecture:** The system is designed with a clear separation between domain logic and external interfaces (ports and adapters).
- **API Technology:** gRPC is used for high-performance communication and a contract-first API design with Protocol Buffers.
- **Persistence:** Hibernate manages the ORM with an H2 database for ease of development and testing.
- **Docker Integration:** A Dockerfile and docker-compose.yml are included to streamline deployment.

---

