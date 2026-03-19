# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy pom.xml and download dependencies (cached if unchanged)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create a directory for H2 datapersistence
RUN mkdir -p /app/data && chmod 777 /app/data

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the API port
EXPOSE 8080

# Environment variable for the data directory (optional, but good practice)
ENV DB_DATA_DIR=/app/data

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
