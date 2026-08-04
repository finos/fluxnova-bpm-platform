# FluxNova Grafana Dashboard

## Dashboard

Import `fluxnova.json` into Grafana via **Dashboards → Import → Upload JSON file**.

When prompted, map the `DS_PROMETHEUS` input to your Prometheus datasource.

---

## Prerequisites

### ⚠️ Prometheus server required

Grafana's Prometheus datasource connects to a **Prometheus server** (e.g. `http://localhost:9090`), not directly to the
scrape endpoint. Pointing Grafana at `http://localhost:8080/actuator/prometheus`
will result in a 404 error because Grafana expects Prometheus's `/api/v1/query` API.

You need a Prometheus server scraping FluxNova, which Grafana then queries.

---

## Local setup (no Docker)

Download the standalone Prometheus binary for Windows:

1. Go to https://github.com/prometheus/prometheus/releases/latest
2. Download `prometheus-x.x.x.windows-amd64.zip`
3. Extract the zip

Create a `prometheus.yml` in the extracted folder:

```yaml
global:
  scrape_interval: 15s

scrape_configs:
  - job_name: fluxnova
    scrape_interval: 15s
    metrics_path: /actuator/prometheus
    static_configs:
      - targets: [ 'localhost:8080' ]
```

Run Prometheus:

```bat
prometheus.exe --config.file=prometheus.yml
```

Prometheus will be available at `http://localhost:9090`.

---

## Add Prometheus datasource in Grafana

1. **Connections → Data sources → Add new data source → Prometheus**
2. Set URL to `http://localhost:9090`
3. Click **Save & test** — should show "Successfully queried the Prometheus API"

---

## FluxNova scrape endpoint

```
http://localhost:8080/actuator/prometheus
```

This endpoint is enabled by default in `fluxnova-spring/configuration/default.yml`. If it returns 404, ensure
`management.endpoints.web.exposure.include` contains `prometheus`.
