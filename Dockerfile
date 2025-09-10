FROM amazoncorretto:21

# Setup required env variables
ENV JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto \
    PATH=$PATH:$JAVA_HOME/bin

# Arguments for DB driver versions
ARG POSTGRESQL_VERSION
ARG MYSQL_VERSION

# Additional Spring/Management properties as env variables
ENV SPRING_H2_CONSOLE_ENABLED=true
ENV SPRING_H2_CONSOLE_SETTINGS_WEB_ALLOW_OTHERS=true

WORKDIR /flowave

# Install packages
RUN yum install -y jq curl shadow-utils unzip

# Expose port
EXPOSE 8080
# Create user and provide access to flowave folder
RUN groupadd -g 4001 flowave_group && adduser -G flowave_group -u 4001 -m -d /flowave flowave_user

# Unzip application
COPY distro/run/distro/target/flowave-bpm-run-*.zip /flowave/
RUN unzip flowave-bpm-run-*.zip

COPY docker-script.sh /flowave/docker-script.sh

# Download PostgreSQL JDBC driver if version specified
RUN if [ -n "$POSTGRESQL_VERSION" ]; then \
      curl -L -o postgresql.jar https://repo1.maven.org/maven2/org/postgresql/postgresql/${POSTGRESQL_VERSION}/postgresql-${POSTGRESQL_VERSION}.jar; \
      mv postgresql.jar configuration/userlib/; \
   fi

# Download MySQL JDBC driver if version specified
RUN if [ -n "$MYSQL_VERSION" ]; then \
      curl -L -o mysql-connector.jar https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/${MYSQL_VERSION}/mysql-connector-j-${MYSQL_VERSION}.jar; \
      mv mysql-connector.jar configuration/userlib/; \
   fi

RUN chown -R flowave_user:flowave_group /flowave

USER 4001

ENTRYPOINT ["sh", "docker-script.sh"]