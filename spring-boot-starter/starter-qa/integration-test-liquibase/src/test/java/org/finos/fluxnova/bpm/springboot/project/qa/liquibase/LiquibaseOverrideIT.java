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

import java.util.List;
import liquibase.integration.spring.SpringLiquibase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/** Verifies that a profile-specific changelog overrides the base application setting. */
@DirtiesContext
@ActiveProfiles("override")
@SpringBootTest(classes = { Application.class },
                webEnvironment = SpringBootTest.WebEnvironment.NONE,
                args = "--spring.config.location=classpath:/liquibase-tests/override/")
public class LiquibaseOverrideIT {

  @Autowired
  SpringLiquibase springLiquibase;

  @Autowired
  JdbcTemplate jdbcTemplate;

  /** Confirms Liquibase executes the user-selected changelog. */
  @Test
  public void shouldUseUserSuppliedChangelog() {
    assertThat(springLiquibase.getChangeLog())
        .isEqualTo("classpath:org/finos/fluxnova/bpm/engine/db/liquibase/camunda-changelog.xml");

    List<String> changelogs = jdbcTemplate.queryForList(
        "SELECT DISTINCT FILENAME FROM DATABASECHANGELOG", String.class);
    assertThat(changelogs).isNotEmpty()
        .allMatch(name -> name.endsWith("/camunda-changelog.xml"));
  }

}
