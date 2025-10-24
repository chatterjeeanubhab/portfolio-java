# Use official Java JDK 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy everything into container
COPY . .

# Make mvnw executable (important for Linux)
RUN chmod +x mvnw

# Build the project
RUN ./mvnw package -DskipTests

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/portfolio-0.0.1-SNAPSHOT.jar"]
