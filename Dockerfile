FROM amazoncorretto:21.0.9

# Setup required env variables
ENV JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto \
    PATH=$PATH:$JAVA_HOME/bin

# Arguments for DB driver versions
ARG POSTGRESQL_VERSION
ARG MYSQL_VERSION

WORKDIR /fluxnova

# Install packages
RUN yum install -y jq curl shadow-utils unzip

# Expose port
EXPOSE 8080
# Create user and provide access to fluxnova folder
RUN groupadd -g 4001 fluxnova_group && adduser -G fluxnova_group -u 4001 -m -d /fluxnova fluxnova_user

# Unzip application
COPY distro/run/distro/target/fluxnova-bpm-run-*.zip /fluxnova/
RUN unzip fluxnova-bpm-run-*.zip

COPY docker-script.sh /fluxnova/docker-script.sh

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

RUN chown -R fluxnova_user:fluxnova_group /fluxnova

USER 4001

ENTRYPOINT ["sh", "docker-script.sh"]