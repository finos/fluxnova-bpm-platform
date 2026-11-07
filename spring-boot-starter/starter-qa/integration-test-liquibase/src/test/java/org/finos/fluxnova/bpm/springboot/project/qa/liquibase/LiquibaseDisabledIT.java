/*
 * Copyright 2025 FINOS
 *
 * The source files in this repository are made available under the Apache License Version 2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * Fluxnova uses and includes third-party dependencies published under various licenses.
 * By downloading and using Fluxnova artifacts, you agree to their terms and conditions.
 */
package org.finos.fluxnova.bpm.springboot.project.qa.liquibase;

import static org.assertj.core.api.Assertions.assertThat;

import liquibase.integration.spring.SpringLiquibase;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.core.env.Environment;

/** Verifies schema initialization when Liquibase is disabled by default. */
@DirtiesContext
@ActiveProfiles("disabled")
@SpringBootTest(classes = { Application.class },
                webEnvironment = SpringBootTest.WebEnvironment.NONE,
                args = "--spring.config.location=classpath:/liquibase-tests/")
public class LiquibaseDisabledIT {

  @Autowired
  ProcessEngine processEngine;

  @Autowired
  ObjectProvider<SpringLiquibase> springLiquibase;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  Environment environment;

  /** Confirms the starter does not run Liquibase by default. */
  @Test
  public void shouldNotRunLiquibase() {
    assertThat(environment.getProperty("spring.liquibase.enabled")).isEqualTo("false");
    assertThat(springLiquibase.getIfAvailable()).isNull();
    assertThat(tableExists("DATABASECHANGELOG")).isFalse();
  }

  /** Confirms the engine creates the schema when Liquibase is disabled. */
  @Test
  public void shouldLetEngineCreateSchema() {
    ProcessEngineConfigurationImpl configuration =
        (ProcessEngineConfigurationImpl) processEngine.getProcessEngineConfiguration();

    assertThat(configuration.getDatabaseSchemaUpdate())
        .isEqualTo(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    assertThat(tableExists("ACT_GE_SCHEMA_LOG")).isTrue();
  }

  /** Checks whether the H2 test database contains a named table. */
  protected boolean tableExists(String table) {
    Integer count = jdbcTemplate.queryForObject(
        "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = ?", Integer.class, table);
    return count != null && count > 0;
  }

}
