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

import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.jdbc.core.JdbcTemplate;
import liquibase.integration.spring.SpringLiquibase;

/** Verifies startup with the starter's default Fluxnova changelog. */
@DirtiesContext
@ActiveProfiles("fluxnova")
@SpringBootTest(classes = { Application.class },
                webEnvironment = SpringBootTest.WebEnvironment.NONE,
                args = "--spring.config.location=classpath:/liquibase-tests/")
public class FluxnovaChangelogIT {

  @Autowired
  ProcessEngine processEngine;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  SpringLiquibase springLiquibase;

  /** Checks that the default changelog applies the expected migrations. */
  @Test
  public void shouldSetUpSchemaWithFluxnovaChangelog() {
    assertThat(springLiquibase.getChangeLog())
        .isEqualTo("classpath:org/finos/fluxnova/bpm/engine/db/liquibase/fluxnova-changelog.xml");
    assertThat(jdbcTemplate.queryForList(
        "SELECT ID FROM DATABASECHANGELOG WHERE EXECTYPE = 'EXECUTED'", String.class))
        .contains(
            "1.0.0-baseline", "1.0.0-tag",
            "1.0-to-2.0", "2.0.0-tag",
            "2.0-to-3.0", "3.0.0-tag",
            "3.0-to-3.1", "3.1.0-tag");

    assertThat(jdbcTemplate.queryForList("SELECT VERSION_ FROM ACT_GE_SCHEMA_LOG", String.class))
        .contains("1.0.0", "2.0.0", "3.0.0", "3.1.0");
  }

  /** Confirms Liquibase takes precedence over engine-managed schema updates. */
  @Test
  public void shouldDisableEngineSchemaUpdate() {
    ProcessEngineConfigurationImpl configuration =
        (ProcessEngineConfigurationImpl) processEngine.getProcessEngineConfiguration();

    assertThat(configuration.getDatabaseSchemaUpdate())
        .isEqualTo(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);
  }

}
