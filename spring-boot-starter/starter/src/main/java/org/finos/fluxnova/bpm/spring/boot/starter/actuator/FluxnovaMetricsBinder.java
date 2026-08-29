package org.finos.fluxnova.bpm.spring.boot.starter.actuator;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;

import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.metrics.Meter;
import org.finos.fluxnova.bpm.engine.impl.metrics.MetricsRegistry;
import org.finos.fluxnova.bpm.engine.management.Metrics;
import org.jspecify.annotations.NonNull;

/**
 * Bridges FluxNova BPM engine metrics into Micrometer so they are exposed via
 * the {@code /actuator/prometheus} scraping endpoint (or any other configured
 * Micrometer registry).
 *
 * <p>Counters are backed by the engine's in-memory diagnostics meters, which
 * accumulate monotonically between calls to
 * {@code ManagementService#clearDiagnosticsMetrics()}. History-cleanup metrics
 * only appear on the db-meters map (no diagnostics copy), so they are exposed
 * as gauges that read the periodic batch value flushed by the DB reporter.</p>
 */
public class FluxnovaMetricsBinder implements MeterBinder {

    private static final String DESCRIPTION_SUFFIX = " (FluxNova BPM engine)";
    private final ProcessEngineConfigurationImpl engineConfiguration;

    public FluxnovaMetricsBinder(ProcessEngineConfigurationImpl engineConfiguration) {
        this.engineConfiguration = engineConfiguration;
    }

    @Override
    public void bindTo(@NonNull MeterRegistry registry) {
        MetricsRegistry metricsRegistry = engineConfiguration.getMetricsRegistry();

        // --- Process instance metrics ---
        bindFunctionCounter(registry, metricsRegistry,
                Metrics.ROOT_PROCESS_INSTANCE_START,
                "fluxnova_process_instance_start_total",
                "Total number of root process instances started");

        // --- Activity / flow-node metrics ---
        bindFunctionCounter(registry, metricsRegistry,
                Metrics.ACTIVTY_INSTANCE_START,
                "fluxnova_activity_instance_start_total",
                "Total number of activity instances started");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.ACTIVTY_INSTANCE_END,
                "fluxnova_activity_instance_end_total",
                "Total number of activity instances completed or terminated");

        // --- Job executor metrics ---
        bindFunctionCounter(registry, metricsRegistry,
                Metrics.JOB_ACQUISITION_ATTEMPT,
                "fluxnova_job_acquisition_attempts_total",
                "Total number of job-acquisition cycles performed by the job executor");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.JOB_ACQUIRED_SUCCESS,
                "fluxnova_job_acquired_total",
                "Total number of jobs successfully acquired (selected and locked)");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.JOB_ACQUIRED_FAILURE,
                "fluxnova_job_acquire_failure_total",
                "Total number of jobs where acquisition was attempted but locking failed");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.JOB_EXECUTION_REJECTED,
                "fluxnova_job_execution_rejected_total",
                "Total number of jobs rejected for execution due to thread-pool saturation");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.JOB_SUCCESSFUL,
                "fluxnova_job_successful_total",
                "Total number of jobs completed successfully");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.JOB_FAILED,
                "fluxnova_job_failed_total",
                "Total number of job executions that ended in failure");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.JOB_LOCKED_EXCLUSIVE,
                "fluxnova_job_locked_exclusive_total",
                "Total number of exclusive jobs immediately locked and executed inline");

        // --- Decision (DMN) metrics ---
        bindFunctionCounter(registry, metricsRegistry,
                Metrics.EXECUTED_DECISION_INSTANCES,
                "fluxnova_decision_instances_total",
                "Total number of DMN decision instances evaluated");

        bindFunctionCounter(registry, metricsRegistry,
                Metrics.EXECUTED_DECISION_ELEMENTS,
                "fluxnova_decision_elements_total",
                "Total number of DMN decision elements evaluated");

        // --- Task worker metrics (gauge – reflects unique workers in current reporting window) ---
        bindGauge(registry, metricsRegistry,
                Metrics.UNIQUE_TASK_WORKERS,
                "fluxnova_task_workers_active",
                "Number of unique task workers observed in the current reporting window");

        // --- History cleanup metrics (db-only meters, exposed as gauges) ---
        bindDbGauge(registry, metricsRegistry,
                Metrics.HISTORY_CLEANUP_REMOVED_PROCESS_INSTANCES,
                "fluxnova_history_cleanup_removed_process_instances_total",
                "Process instances removed by the last history-cleanup run");

        bindDbGauge(registry, metricsRegistry,
                Metrics.HISTORY_CLEANUP_REMOVED_CASE_INSTANCES,
                "fluxnova_history_cleanup_removed_case_instances_total",
                "Case instances removed by the last history-cleanup run");

        bindDbGauge(registry, metricsRegistry,
                Metrics.HISTORY_CLEANUP_REMOVED_DECISION_INSTANCES,
                "fluxnova_history_cleanup_removed_decision_instances_total",
                "Decision instances removed by the last history-cleanup run");

        bindDbGauge(registry, metricsRegistry,
                Metrics.HISTORY_CLEANUP_REMOVED_BATCH_OPERATIONS,
                "fluxnova_history_cleanup_removed_batch_operations_total",
                "Batch operations removed by the last history-cleanup run");

        bindDbGauge(registry, metricsRegistry,
                Metrics.HISTORY_CLEANUP_REMOVED_TASK_METRICS,
                "fluxnova_history_cleanup_removed_task_metrics_total",
                "Task-metric records removed by the last history-cleanup run");
    }

    /**
     * Registers a {@link FunctionCounter} backed by the diagnostics meter for the
     * given engine metric name. Diagnostics meters accumulate monotonically and are
     * therefore a natural fit for Prometheus counters.
     */
    private void bindFunctionCounter(MeterRegistry registry,
                                     MetricsRegistry metricsRegistry,
                                     String engineMetricName,
                                     String prometheusName,
                                     String description) {
        Meter meter = metricsRegistry.getDiagnosticsMeters().get(engineMetricName);
        if (meter == null) {
            return;
        }
        FunctionCounter.builder(prometheusName, meter, m -> (double) m.get())
                .description(description + DESCRIPTION_SUFFIX)
                .register(registry);
    }

    /**
     * Registers a {@link Gauge} backed by the diagnostics meter. Suitable for
     * values that represent an instantaneous measurement rather than a cumulative total.
     */
    private void bindGauge(MeterRegistry registry,
                           MetricsRegistry metricsRegistry,
                           String engineMetricName,
                           String prometheusName,
                           String description) {
        Meter meter = metricsRegistry.getDiagnosticsMeters().get(engineMetricName);
        if (meter == null) {
            return;
        }
        Gauge.builder(prometheusName, meter, m -> (double) m.get())
                .description(description + DESCRIPTION_SUFFIX)
                .register(registry);
    }

    /**
     * Registers a {@link Gauge} backed by the db meter. Used for history-cleanup
     * metrics which are only tracked in the db-meters map (no diagnostics copy).
     */
    private void bindDbGauge(MeterRegistry registry,
                             MetricsRegistry metricsRegistry,
                             String engineMetricName,
                             String prometheusName,
                             String description) {
        Meter meter = metricsRegistry.getDbMeterByName(engineMetricName);
        if (meter == null) {
            return;
        }
        Gauge.builder(prometheusName, meter, m -> (double) m.get())
                .description(description + DESCRIPTION_SUFFIX)
                .register(registry);
    }
}
