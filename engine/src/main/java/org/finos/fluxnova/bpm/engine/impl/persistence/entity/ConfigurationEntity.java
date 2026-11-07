package org.finos.fluxnova.bpm.engine.impl.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.impl.db.DbEntity;

public class ConfigurationEntity implements Configuration, Serializable, DbEntity {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String configKey;
  protected String tenantId;
  protected String configValue;
  protected int version = 1;
  protected String status = STATUS_ACTIVE;
  protected String createdBy;
  protected Date createdAt;
  protected String updatedBy;
  protected Date updatedAt;

  public ConfigurationEntity() {
  }

  public ConfigurationEntity(String configKey, String configValue, String tenantId) {
    this.configKey = configKey;
    this.configValue = configValue;
    this.tenantId = tenantId;
  }

  public Object getPersistentState() {
    Map<String, Object> persistentState = new HashMap<String, Object>();
    persistentState.put("configValue", configValue);
    persistentState.put("version", version);
    persistentState.put("status", status);
    persistentState.put("updatedBy", updatedBy);
    persistentState.put("updatedAt", updatedAt);
    return persistentState;
  }

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

  @Override
  public String toString() {
    return "ConfigurationEntity [id=" + id
        + ", configKey=" + configKey
        + ", tenantId=" + tenantId
        + ", version=" + version
        + ", status=" + status + "]";
  }

}
