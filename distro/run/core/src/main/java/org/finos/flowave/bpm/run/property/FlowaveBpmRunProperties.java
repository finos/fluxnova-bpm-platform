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
package org.finos.flowave.bpm.run.property;

import org.finos.flowave.bpm.spring.boot.starter.property.FlowaveBpmProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(FlowaveBpmRunProperties.PREFIX)
public class FlowaveBpmRunProperties {

  public static final String PREFIX = FlowaveBpmProperties.PREFIX + ".run";

  @NestedConfigurationProperty
  protected FlowaveBpmRunAuthenticationProperties auth = new FlowaveBpmRunAuthenticationProperties();

  @NestedConfigurationProperty
  protected FlowaveBpmRunCorsProperty cors = new FlowaveBpmRunCorsProperty();

  @NestedConfigurationProperty
  protected FlowaveBpmRunLdapProperties ldap = new FlowaveBpmRunLdapProperties();

  @NestedConfigurationProperty
  protected List<FlowaveBpmRunProcessEnginePluginProperty> processEnginePlugins = new ArrayList<>();

  @NestedConfigurationProperty
  protected FlowaveBpmRunRestProperties rest = new FlowaveBpmRunRestProperties();

  @NestedConfigurationProperty
  protected FlowaveBpmRunDeploymentProperties deployment = new FlowaveBpmRunDeploymentProperties();

  protected FlowaveBpmRunAdministratorAuthorizationProperties adminAuth
      = new FlowaveBpmRunAdministratorAuthorizationProperties();

  public FlowaveBpmRunAuthenticationProperties getAuth() {
    return auth;
  }

  public void setAuth(FlowaveBpmRunAuthenticationProperties auth) {
    this.auth = auth;
  }

  public FlowaveBpmRunCorsProperty getCors() {
    return cors;
  }

  public void setCors(FlowaveBpmRunCorsProperty cors) {
    this.cors = cors;
  }

  public FlowaveBpmRunLdapProperties getLdap() {
    return ldap;
  }

  public void setLdap(FlowaveBpmRunLdapProperties ldap) {
    this.ldap = ldap;
  }

  public FlowaveBpmRunAdministratorAuthorizationProperties getAdminAuth() {
    return adminAuth;
  }

  public void setAdminAuth(FlowaveBpmRunAdministratorAuthorizationProperties adminAuth) {
    this.adminAuth = adminAuth;
  }

  public List<FlowaveBpmRunProcessEnginePluginProperty> getProcessEnginePlugins() {
    return processEnginePlugins;
  }

  public void setProcessEnginePlugins(List<FlowaveBpmRunProcessEnginePluginProperty> processEnginePlugins) {
    this.processEnginePlugins = processEnginePlugins;
  }

  public FlowaveBpmRunRestProperties getRest() {
    return rest;
  }

  public void setRest(FlowaveBpmRunRestProperties rest) {
    this.rest = rest;
  }

  public FlowaveBpmRunDeploymentProperties getDeployment() {
    return deployment;
  }

  public void setDeployment(FlowaveBpmRunDeploymentProperties deployment) {
    this.deployment = deployment;
  }


  @Override
  public String toString() {
    return "FlowaveBpmRunProperties [" +
        "auth=" + auth +
        ", cors=" + cors +
        ", ldap=" + ldap +
        ", adminAuth=" + adminAuth +
        ", plugins=" + processEnginePlugins +
        ", rest=" + rest +
        ", deployment=" + deployment +
        "]";
  }
}
