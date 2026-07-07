FROM amazoncorretto:21

# Setup required env variables
ENV JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto \
    PATH=$PATH:$JAVA_HOME/bin

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

RUN chown -R fluxnova_user:fluxnova_group /fluxnova

USER 4001

ENTRYPOINT ["sh", "docker-script.sh"]