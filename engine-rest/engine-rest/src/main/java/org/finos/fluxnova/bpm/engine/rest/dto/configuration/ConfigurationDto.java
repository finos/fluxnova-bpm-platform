/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.engine.rest.dto.configuration;

import java.util.Date;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;

/**
 * Response DTO representing a persisted process configuration entry.
 */
public class ConfigurationDto {

  private String id;
  private String configKey;
  private String tenantId;
  private String configValue;
  private int version;
  private String status;
  private String createdBy;
  private Date createdAt;
  private String updatedBy;
  private Date updatedAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getConfigKey() {
    return configKey;
  }

  public void setConfigKey(String configKey) {
    this.configKey = configKey;
  }

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * Creates a DTO from the given configuration.
   *
   * @param configuration the configuration to convert, must not be {@code null}
   * @return the corresponding DTO
   */
  public static ConfigurationDto fromConfiguration(Configuration configuration) {
    ConfigurationDto dto = new ConfigurationDto();
    dto.setId(configuration.getId());
    dto.setConfigKey(configuration.getConfigKey());
    dto.setTenantId(configuration.getTenantId());
    dto.setConfigValue(configuration.getConfigValue());
    dto.setVersion(configuration.getVersion());
    dto.setStatus(configuration.getStatus());
    dto.setCreatedBy(configuration.getCreatedBy());
    dto.setCreatedAt(configuration.getCreatedAt());
    dto.setUpdatedBy(configuration.getUpdatedBy());
    dto.setUpdatedAt(configuration.getUpdatedAt());
    return dto;
  }
}
