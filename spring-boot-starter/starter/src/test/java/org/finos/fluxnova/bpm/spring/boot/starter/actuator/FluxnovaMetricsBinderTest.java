package org.finos.fluxnova.bpm.spring.boot.starter.actuator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.metrics.MetricsRegistry;
import org.finos.fluxnova.bpm.engine.management.Metrics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
public class FluxnovaMetricsBinderTest {

  @Mock
  private ProcessEngineConfigurationImpl engineConfiguration;

  private MetricsRegistry metricsRegistry;
  private MeterRegistry meterRegistry;

  @BeforeEach
  void setUp() {
    metricsRegistry = new MetricsRegistry();

    // Diagnostics + db meters (process, activity, job, DMN, task workers)
    metricsRegistry.createMeter(Metrics.ROOT_PROCESS_INSTANCE_START);
    metricsRegistry.createMeter(Metrics.ACTIVTY_INSTANCE_START);
    metricsRegistry.createMeter(Metrics.ACTIVTY_INSTANCE_END);
    metricsRegistry.createMeter(Metrics.JOB_ACQUISITION_ATTEMPT);
    metricsRegistry.createMeter(Metrics.JOB_ACQUIRED_SUCCESS);
    metricsRegistry.createMeter(Metrics.JOB_ACQUIRED_FAILURE);
    metricsRegistry.createMeter(Metrics.JOB_EXECUTION_REJECTED);
    metricsRegistry.createMeter(Metrics.JOB_SUCCESSFUL);
    metricsRegistry.createMeter(Metrics.JOB_FAILED);
    metricsRegistry.createMeter(Metrics.JOB_LOCKED_EXCLUSIVE);
    metricsRegistry.createMeter(Metrics.EXECUTED_DECISION_INSTANCES);
    metricsRegistry.createMeter(Metrics.EXECUTED_DECISION_ELEMENTS);
    metricsRegistry.createMeter(Metrics.UNIQUE_TASK_WORKERS);

    // Db-only meters (history cleanup)
    metricsRegistry.createDbMeter(Metrics.HISTORY_CLEANUP_REMOVED_PROCESS_INSTANCES);
    metricsRegistry.createDbMeter(Metrics.HISTORY_CLEANUP_REMOVED_CASE_INSTANCES);
    metricsRegistry.createDbMeter(Metrics.HISTORY_CLEANUP_REMOVED_DECISION_INSTANCES);
    metricsRegistry.createDbMeter(Metrics.HISTORY_CLEANUP_REMOVED_BATCH_OPERATIONS);
    metricsRegistry.createDbMeter(Metrics.HISTORY_CLEANUP_REMOVED_TASK_METRICS);

    when(engineConfiguration.getMetricsRegistry()).thenReturn(metricsRegistry);

    meterRegistry = new SimpleMeterRegistry();
    new FluxnovaMetricsBinder(engineConfiguration).bindTo(meterRegistry);
  }

  @Test
  void allExpectedMetersAreRegistered() {
    assertNotNull(meterRegistry.find("fluxnova_process_instance_start_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_activity_instance_start_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_activity_instance_end_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_job_acquisition_attempts_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_job_acquired_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_job_acquire_failure_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_job_execution_rejected_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_job_successful_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_job_failed_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_job_locked_exclusive_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_decision_instances_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_decision_elements_total").functionCounter());
    assertNotNull(meterRegistry.find("fluxnova_task_workers_active").gauge());
    assertNotNull(meterRegistry.find("fluxnova_history_cleanup_removed_process_instances_total").gauge());
    assertNotNull(meterRegistry.find("fluxnova_history_cleanup_removed_case_instances_total").gauge());
    assertNotNull(meterRegistry.find("fluxnova_history_cleanup_removed_decision_instances_total").gauge());
    assertNotNull(meterRegistry.find("fluxnova_history_cleanup_removed_batch_operations_total").gauge());
    assertNotNull(meterRegistry.find("fluxnova_history_cleanup_removed_task_metrics_total").gauge());
  }

  @Test
  void counterReflectsEngineDiagnosticsOccurrences() {
    metricsRegistry.markOccurrence(Metrics.ROOT_PROCESS_INSTANCE_START, 3);

    FunctionCounter counter = meterRegistry.find("fluxnova_process_instance_start_total").functionCounter();
    assertNotNull(counter);
    assertEquals(3.0, counter.count());
  }

  @Test
  void dbGaugeReflectsHistoryCleanupMeterValue() {
    metricsRegistry.markOccurrence(Metrics.HISTORY_CLEANUP_REMOVED_PROCESS_INSTANCES, 5);

    Gauge gauge = meterRegistry.find("fluxnova_history_cleanup_removed_process_instances_total").gauge();
    assertNotNull(gauge);
    assertEquals(5.0, gauge.value());
  }

  @Test
  void diagnosticsGaugeReflectsTaskWorkerMeterValue() {
    metricsRegistry.markOccurrence(Metrics.UNIQUE_TASK_WORKERS, 7);

    Gauge gauge = meterRegistry.find("fluxnova_task_workers_active").gauge();
    assertNotNull(gauge);
    assertEquals(7.0, gauge.value());
  }

  @Test
  void missingDiagnosticsMeterIsSkippedGracefully() {
    MetricsRegistry emptyRegistry = new MetricsRegistry();
    when(engineConfiguration.getMetricsRegistry()).thenReturn(emptyRegistry);
    MeterRegistry emptyMicrometerRegistry = new SimpleMeterRegistry();

    new FluxnovaMetricsBinder(engineConfiguration).bindTo(emptyMicrometerRegistry);

    assertNull(emptyMicrometerRegistry.find("fluxnova_process_instance_start_total").functionCounter());
    assertNull(emptyMicrometerRegistry.find("fluxnova_task_workers_active").gauge());
  }

  @Test
  void missingDbMeterIsSkippedGracefully() {
    MetricsRegistry emptyRegistry = new MetricsRegistry();
    when(engineConfiguration.getMetricsRegistry()).thenReturn(emptyRegistry);
    MeterRegistry emptyMicrometerRegistry = new SimpleMeterRegistry();

    new FluxnovaMetricsBinder(engineConfiguration).bindTo(emptyMicrometerRegistry);

    assertNull(emptyMicrometerRegistry.find("fluxnova_history_cleanup_removed_process_instances_total").gauge());
  }
}
