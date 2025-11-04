# Java Spring Boot Sample Application

## Overview
This is a Spring Boot REST API application that provides CRUD operations for a Model entity. The application uses:
- Java 19 (GraalVM)
- Spring Boot 3.2.5
- H2 in-memory database
- Maven for build management

## Project Structure
- `src/main/java/com/hackerrank/sample/` - Main application source code
  - `controller/` - REST API endpoints
  - `service/` - Business logic layer
  - `repository/` - Data access layer
  - `model/` - Entity classes
  - `exception/` - Custom exception classes
- `src/main/resources/` - Configuration files
- `src/test/` - Test files

## API Endpoints
- `GET /` - Home page (returns welcome message)
- `POST /model` - Create a new model (JSON body required)
- `GET /model` - Get all models
- `GET /model/{id}` - Get model by ID
- `DELETE /model/{id}` - Delete model by ID
- `DELETE /erase` - Delete all models
- `GET /h2-console` - H2 database console (for debugging)

## Database
The application uses an H2 in-memory database configured to:
- Run on startup and persist during application runtime
- Automatically create schema from entity classes
- Accessible via H2 console at `/h2-console`

## Development
The application runs on port 5000 and binds to 0.0.0.0 for Replit compatibility.

## Build & Run
- Build: `mvn clean package`
- Run: `mvn spring-boot:run`

## Recent Changes
- 2025-11-04: Initial setup for Replit environment
  - Configured Java 19 compatibility (downgraded from Java 21)
  - Created application.properties with server and database configuration
  - Implemented controller methods to call service layer
  - Set up H2 database with proper connection settings
  - Configured workflow to run on port 5000
