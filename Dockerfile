# Build stage
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy the pom.xml and src directory into the container
COPY pom.xml /app/
COPY src /app/src/

# Build the project (including dependencies)
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the packaged JAR from the build stage to the runtime stage
COPY --from=build /app/target/*.jar app.jar

# Specify the command to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
