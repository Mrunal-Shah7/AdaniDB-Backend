# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x ./mvnw

# Build the dependencies (to cache them)
RUN ./mvnw dependency:go-offline

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw clean package -DskipTests

# Run the jar file
CMD ["sh", "-c", "java -jar target/AdaniDB-*.jar"]