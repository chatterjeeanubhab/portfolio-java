# ---------- Build Stage ----------
# Use Maven + JDK 17 image to build
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only pom.xml first to leverage Docker cache
COPY pom.xml .

# Download dependencies first (faster rebuilds)
RUN mvn dependency:go-offline -B

# Now copy the source code
COPY src ./src

# Build the application (skip tests)
RUN mvn clean package -DskipTests -B -U

# ---------- Run Stage ----------
# Use JDK 17 runtime image to run
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (Spring Boot default)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
