FROM ubuntu:latest
LABEL authors="ASUS"

ENTRYPOINT ["top", "-b"]

# Use an official JDK image
FROM openjdk:17-jdk

# Set the working directory
WORKDIR /app

# Copy the application JAR file (replace with your actual JAR file)
COPY target/HubNet-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
