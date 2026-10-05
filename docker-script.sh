#!/bin/bash
set -Eeu

# Set Password as Docker Secrets for Swarm-Mode
if [[ -z "${DB_PASSWORD:-}" && -n "${DB_PASSWORD_FILE:-}" && -f "${DB_PASSWORD_FILE:-}" ]]; then
  export DB_PASSWORD="$(< "${DB_PASSWORD_FILE}")"
fi

# For compatibility: when DB_ variables are set, translate them to SPRING_ variables.
if [[ -z "${SPRING_DATASOURCE_DRIVER_CLASS_NAME:-}" && -n "${DB_DRIVER:-}" ]]; then
  export SPRING_DATASOURCE_DRIVER_CLASS_NAME="${DB_DRIVER}"
fi

if [[ -z "${SPRING_DATASOURCE_PASSWORD:-}" && -n "${DB_PASSWORD:-}" ]]; then
  export SPRING_DATASOURCE_PASSWORD="${DB_PASSWORD}"
fi

if [[ -z "${SPRING_DATASOURCE_USERNAME:-}" && -n "${DB_USERNAME:-}" ]]; then
  export SPRING_DATASOURCE_USERNAME="${DB_USERNAME}"
fi

if [[ -z "${SPRING_DATASOURCE_URL:-}" && -n "${DB_URL:-}" ]]; then
  export SPRING_DATASOURCE_URL="${DB_URL}"
fi

CMD="/fluxnova/start.sh"

# If PEM certs are mounted, import them into a truststore that also includes the default JVM CAs.
# Mount individual .crt files to /fluxnova/certs/ or set EXTRA_CERTS_DIR to a directory of .crt files.
CERT_DIR="${EXTRA_CERTS_DIR:-/fluxnova/certs}"
TRUSTSTORE="/tmp/truststore.jks"
if [ -d "${CERT_DIR}" ] && ls "${CERT_DIR}"/*.crt 1>/dev/null 2>&1; then
  # Start from the JVM's default CA bundle so we don't break other TLS connections.
  DEFAULT_CACERTS="${JAVA_HOME}/lib/security/cacerts"
  cp "${DEFAULT_CACERTS}" "${TRUSTSTORE}"
  chmod 600 "${TRUSTSTORE}"

  for cert in "${CERT_DIR}"/*.crt; do
    alias=$(basename "${cert}" .crt)
    keytool -importcert -noprompt -trustcacerts \
      -keystore "${TRUSTSTORE}" \
      -storepass "${TRUSTSTORE_PASSWORD:-changeit}" \
      -alias "${alias}" \
      -file "${cert}"
    echo "Imported certificate: ${alias}"
  done
  export JAVA_TOOL_OPTIONS="${JAVA_TOOL_OPTIONS:-} -Djavax.net.ssl.trustStore=${TRUSTSTORE} -Djavax.net.ssl.trustStorePassword=${TRUSTSTORE_PASSWORD:-changeit}"
fi

exec "${CMD}"