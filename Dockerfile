ARG DOCKER_REGISTRY=docker.io

FROM ${DOCKER_REGISTRY}/alpine:3 AS app-packager

ARG ALPINE_REGISTRY=https://dl-cdn.alpinelinux.org/alpine

RUN ALPINE_VERSION=$(cat /etc/alpine-release | cut -d'.' -f1,2) && \
    echo "${ALPINE_REGISTRY}/v${ALPINE_VERSION}/main/" > /etc/apk/repositories && \
    echo "${ALPINE_REGISTRY}/v${ALPINE_VERSION}/community/" >> /etc/apk/repositories && \
    apk add --no-cache unzip && rm -fr /var/cache/apk/*

WORKDIR /fluxnova

COPY distro/run/distro/target/fluxnova-bpm-run-*.zip /tmp/fluxnova-bpm-run.zip

RUN unzip /tmp/fluxnova-bpm-run.zip -d /fluxnova && rm -f /tmp/fluxnova-bpm-run.zip

COPY docker-script.sh /fluxnova/docker-script.sh

###### DNF BASED IMAGE ######
FROM ${DOCKER_REGISTRY}/amazoncorretto:21 AS corretto21

ENV JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto \
    PATH=$PATH:$JAVA_HOME/bin

WORKDIR /fluxnova

RUN --mount=type=secret,id=dnf_repo,required=false \
    --mount=type=secret,id=trust_cert,required=false \
    if [ -f /run/secrets/trust_cert ]; then \
      install -m 644 /run/secrets/trust_cert /etc/pki/ca-trust/source/anchors/custom-ca.pem; \
      update-ca-trust; \
    fi \
    && \
    if [ -f /run/secrets/dnf_repo ]; then \
      install -m 600 /run/secrets/dnf_repo /etc/yum.repos.d/custom.repo; \
    fi \
    && dnf clean all \
    && dnf makecache \
    && dnf swap -y curl-minimal curl --allowerasing \
    && dnf install -y bash jq shadow-utils unzip ca-certificates \
    && dnf clean all \
    && rm -rf /var/cache/dnf \
    && rm -f /etc/yum.repos.d/custom.repo

COPY --from=app-packager /fluxnova /fluxnova

RUN groupadd -g 4001 fluxnova_group && useradd -M -d /fluxnova -g fluxnova_group -u 4001 fluxnova_user && \
    chown -R fluxnova_user:fluxnova_group /fluxnova

EXPOSE 8080

USER 4001

ENTRYPOINT ["/bin/bash", "/fluxnova/docker-script.sh"]

###### ALPINE BASED IMAGE ######
FROM ${DOCKER_REGISTRY}/amazoncorretto:21-alpine AS corretto21_alpine

ARG ALPINE_REGISTRY=https://dl-cdn.alpinelinux.org/alpine

ENV JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto \
    PATH=$PATH:$JAVA_HOME/bin

WORKDIR /fluxnova

RUN ALPINE_VERSION=$(cat /etc/alpine-release | cut -d'.' -f1,2) && \
    echo "${ALPINE_REGISTRY}/v${ALPINE_VERSION}/main/" > /etc/apk/repositories && \
    echo "${ALPINE_REGISTRY}/v${ALPINE_VERSION}/community/" >> /etc/apk/repositories && \
    apk add --no-cache bash jq curl shadow unzip ca-certificates && \
    rm -fr /var/cache/apk/*

COPY --from=app-packager /fluxnova /fluxnova

RUN groupadd -g 4001 fluxnova_group && useradd -M -d /fluxnova -g fluxnova_group -u 4001 fluxnova_user && \
    chown -R fluxnova_user:fluxnova_group /fluxnova

EXPOSE 8080

USER 4001

ENTRYPOINT ["/bin/bash", "/fluxnova/docker-script.sh"]
