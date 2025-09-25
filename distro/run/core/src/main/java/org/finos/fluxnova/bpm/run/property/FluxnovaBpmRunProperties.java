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
package org.finos.fluxnova.bpm.run.property;

import org.finos.fluxnova.bpm.spring.boot.starter.property.FluxnovaBpmProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(FluxnovaBpmRunProperties.PREFIX)
public class FluxnovaBpmRunProperties {

  public static final String PREFIX = FluxnovaBpmProperties.PREFIX + ".run";

  @NestedConfigurationProperty
  protected FluxnovaBpmRunAuthenticationProperties auth = new FluxnovaBpmRunAuthenticationProperties();

  @NestedConfigurationProperty
  protected FluxnovaBpmRunCorsProperty cors = new FluxnovaBpmRunCorsProperty();

  @NestedConfigurationProperty
  protected FluxnovaBpmRunLdapProperties ldap = new FluxnovaBpmRunLdapProperties();

  @NestedConfigurationProperty
  protected List<FluxnovaBpmRunProcessEnginePluginProperty> processEnginePlugins = new ArrayList<>();

  @NestedConfigurationProperty
  protected FluxnovaBpmRunRestProperties rest = new FluxnovaBpmRunRestProperties();

  @NestedConfigurationProperty
  protected FluxnovaBpmRunDeploymentProperties deployment = new FluxnovaBpmRunDeploymentProperties();

  protected FluxnovaBpmRunAdministratorAuthorizationProperties adminAuth
      = new FluxnovaBpmRunAdministratorAuthorizationProperties();

  public FluxnovaBpmRunAuthenticationProperties getAuth() {
    return auth;
  }

  public void setAuth(FluxnovaBpmRunAuthenticationProperties auth) {
    this.auth = auth;
  }

  public FluxnovaBpmRunCorsProperty getCors() {
    return cors;
  }

  public void setCors(FluxnovaBpmRunCorsProperty cors) {
    this.cors = cors;
  }

  public FluxnovaBpmRunLdapProperties getLdap() {
    return ldap;
  }

  public void setLdap(FluxnovaBpmRunLdapProperties ldap) {
    this.ldap = ldap;
  }

  public FluxnovaBpmRunAdministratorAuthorizationProperties getAdminAuth() {
    return adminAuth;
  }

  public void setAdminAuth(FluxnovaBpmRunAdministratorAuthorizationProperties adminAuth) {
    this.adminAuth = adminAuth;
  }

  public List<FluxnovaBpmRunProcessEnginePluginProperty> getProcessEnginePlugins() {
    return processEnginePlugins;
  }

  public void setProcessEnginePlugins(List<FluxnovaBpmRunProcessEnginePluginProperty> processEnginePlugins) {
    this.processEnginePlugins = processEnginePlugins;
  }

  public FluxnovaBpmRunRestProperties getRest() {
    return rest;
  }

  public void setRest(FluxnovaBpmRunRestProperties rest) {
    this.rest = rest;
  }

  public FluxnovaBpmRunDeploymentProperties getDeployment() {
    return deployment;
  }

  public void setDeployment(FluxnovaBpmRunDeploymentProperties deployment) {
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
