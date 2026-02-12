# Use the official MVN image
FROM maven:3.9.12-eclipse-temurin-21-noble

ENV M2_HOME=/usr/share/maven

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Java class to the working directory
COPY target/fluxnova-migrator*.jar /app/fluxnova-migrator.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/fluxnova-migrator.jar"]
