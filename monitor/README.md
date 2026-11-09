# FluxNova Monitoring

FluxNova exposes engine metrics via [Micrometer](https://micrometer.io/), making them compatible with any
Micrometer-supported monitoring system. The reference setup uses **Prometheus + Grafana**.

---

## How it works

`FluxnovaMetricsBinder` bridges the engine's internal `MetricsRegistry` into Micrometer. On start up it registers:

| Micrometer metric                                           | Type    | Description                                                 |
|-------------------------------------------------------------|---------|-------------------------------------------------------------|
| `fluxnova_process_instance_start_total`                     | Counter | Root process instances started                              |
| `fluxnova_activity_instance_start_total`                    | Counter | Activity instances started                                  |
| `fluxnova_activity_instance_end_total`                      | Counter | Activity instances completed or terminated                  |
| `fluxnova_job_acquisition_attempts_total`                   | Counter | Job-acquisition cycles performed                            |
| `fluxnova_job_acquired_total`                               | Counter | Jobs successfully acquired and locked                       |
| `fluxnova_job_acquire_failure_total`                        | Counter | Jobs where locking failed                                   |
| `fluxnova_job_execution_rejected_total`                     | Counter | Jobs rejected due to thread-pool saturation                 |
| `fluxnova_job_successful_total`                             | Counter | Jobs completed successfully                                 |
| `fluxnova_job_failed_total`                                 | Counter | Job executions that ended in failure                        |
| `fluxnova_job_locked_exclusive_total`                       | Counter | Exclusive jobs locked and executed inline                   |
| `fluxnova_decision_instances_total`                         | Counter | DMN decision instances evaluated                            |
| `fluxnova_decision_elements_total`                          | Counter | DMN decision elements evaluated                             |
| `fluxnova_task_workers_active`                              | Gauge   | Unique task workers in the current reporting window         |
| `fluxnova_history_cleanup_removed_process_instances_total`  | Gauge   | Process instances removed by the last history-cleanup run   |
| `fluxnova_history_cleanup_removed_case_instances_total`     | Gauge   | Case instances removed by the last history-cleanup run      |
| `fluxnova_history_cleanup_removed_decision_instances_total` | Gauge   | Decision instances removed by the last history-cleanup run  |
| `fluxnova_history_cleanup_removed_batch_operations_total`   | Gauge   | Batch operations removed by the last history-cleanup run    |
| `fluxnova_history_cleanup_removed_task_metrics_total`       | Gauge   | Task-metric records removed by the last history-cleanup run |

Counters are backed by the engine's in-memory **diagnostics meters**, which only ever increase. History-cleanup
metrics are backed by **db meters** (the periodic batch value flushed by the DB reporter), so they are exposed as
gauges.

---

## Spring Boot setup

`FluxnovaMetricsBinder` is registered automatically as a Spring bean by `FluxnovaBpmActuatorConfiguration` when:

- `spring-boot-starter-actuator` and `micrometer-registry-prometheus` are on the classpath, **and**
- the property `management.metrics.fluxnova.enabled` is `true` (the default)

To disable the binder without removing the dependency:

```yaml
management:
  metrics:
    fluxnova:
      enabled: false
```

To expose the Prometheus scrape endpoint:

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health, prometheus
  endpoint:
    prometheus:
      access: unrestricted
```

The scrape endpoint is then available at:

```
http://localhost:8080/actuator/prometheus
```

---

## Manual wiring (non-Spring)

`FluxnovaMetricsBinder` has no Spring dependency and can be wired manually with any Micrometer `MeterRegistry`:

```java
ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
ProcessEngineConfigurationImpl config =
    (ProcessEngineConfigurationImpl) engine.getProcessEngineConfiguration();

// Use any Micrometer registry — e.g. PrometheusMeterRegistry
PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

new FluxnovaMetricsBinder(config).bindTo(registry);

// Expose the registry's scrape output via your own HTTP server, e.g.:
// String scrapeOutput = registry.scrape();
```

To expose the scrape output over HTTP without Spring Boot, add a simple handler to your existing server. For example,
with a plain `HttpServer`:

```java
HttpServer server = HttpServer.create(new InetSocketAddress(9090), 0);
server.createContext("/metrics", exchange -> {
    String body = registry.scrape();
    exchange.sendResponseHeaders(200, body.getBytes().length);
    try (OutputStream os = exchange.getResponseBody()) {
        os.write(body.getBytes());
    }
});
server.start();
```

Point Prometheus at `http://localhost:9090/metrics`.

---

## Grafana dashboard

A pre-built Grafana dashboard is provided in [`grafana/fluxnova.json`](grafana/fluxnova.json).

Import it via **Dashboards → Import → Upload JSON file** and map the `DS_PROMETHEUS` input to your Prometheus
datasource.

---

## Prometheus setup

### ⚠️ Prometheus server required

Grafana's Prometheus datasource connects to a **Prometheus server** (e.g. `http://localhost:9090`), not directly to the
scrape endpoint. Pointing Grafana at `http://localhost:8080/actuator/prometheus` will result in a 404 error because
Grafana expects Prometheus's `/api/v1/query` API.

You need a Prometheus server scraping FluxNova, which Grafana then queries.

### Local setup (no Docker)

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

### Add Prometheus datasource in Grafana

1. **Connections → Data sources → Add new data source → Prometheus**
2. Set URL to `http://localhost:9090`
3. Click **Save & test** — should show "Successfully queried the Prometheus API"
