# Accident Blackspot Detection System - Backend

## Overview
This is a Spring Boot application that serves as the backend for an Accident Blackspot Detection System. The system identifies and visualizes accident-prone areas (blackspots) based on various parameters like weather conditions and time of day using the DBSCAN clustering algorithm.

## Features
- Upload accident data via Excel files
- Query accident data based on weather and time
- Identify blackspots using DBSCAN clustering algorithm
- Secure and unsecured user authentication endpoints
- RESTful API for frontend integration

## Technology Stack
- Java 8+
- Spring Boot
- Spring Data JPA
- Hibernate ORM
- Microsoft SQL Server
- Apache POI (for Excel file processing)

## Project Structure
- **model**: Contains entity classes (User, accident, location, etc.)
- **repository**: Data access interfaces
- **controller**: REST endpoints
- **service**: Business logic layer including clustering algorithm
- **Clustering**: DBSCAN implementation for blackspot detection

## API Endpoints

### Accident Data
- `POST /controller/uploadfile`: Upload accident data from Excel file
- `GET /controller/blackspots`: Get all accident data
- `GET /controller/blackspots/clusters/{weather}/{time}`: Get clusters of accidents based on weather and time parameters

### User Authentication
- `POST /controller/details/unsecured`: User authentication (unsecured)
- `POST /controller/details/secured`: User authentication (secured)

## DBSCAN Clustering
The system uses the DBSCAN (Density-Based Spatial Clustering of Applications with Noise) algorithm for identifying accident blackspots. Parameters:
- Epsilon (radius): 2 km
- Minimum Points: 5

## Setup and Installation
1. Ensure you have Java 8+ and Maven installed
2. Configure your SQL Server database
3. Clone the repository
4. Update `application.properties` with your database credentials
5. Run `mvn spring-boot:run` to start the application

## Security Considerations
- The system includes both secured and unsecured endpoints for demonstration purposes
- **Warning**: The unsecured endpoint is vulnerable to SQL injection and should NOT be used in production

## Cross-Origin Resource Sharing
The backend is configured to accept requests from `http://localhost:3000` for development purposes.
