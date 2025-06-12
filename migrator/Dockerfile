# Use the official MVN image
FROM maven:3.9.9-eclipse-temurin-21-noble

ENV M2_HOME=/usr/share/maven

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Java class to the working directory
COPY target/flowave-migrator*.jar /app/flowave-migrator.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/flowave-migrator.jar"]
