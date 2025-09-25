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
package org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.custom;

import org.finos.fluxnova.bpm.engine.AuthorizationService;
import org.finos.fluxnova.bpm.engine.IdentityService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.authorization.Groups;
import org.finos.fluxnova.bpm.engine.authorization.Resource;
import org.finos.fluxnova.bpm.engine.authorization.Resources;
import org.finos.fluxnova.bpm.engine.identity.Group;
import org.finos.fluxnova.bpm.engine.identity.User;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.AuthorizationEntity;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.AbstractFluxnovaConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.property.AdminUserProperty;
import org.springframework.beans.BeanUtils;

import jakarta.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static org.finos.fluxnova.bpm.engine.authorization.Authorization.ANY;
import static org.finos.fluxnova.bpm.engine.authorization.Authorization.AUTH_TYPE_GRANT;
import static org.finos.fluxnova.bpm.engine.authorization.Groups.CAMUNDA_ADMIN;
import static org.finos.fluxnova.bpm.engine.authorization.Permissions.ALL;

public class CreateAdminUserConfiguration extends AbstractFluxnovaConfiguration {

  private User adminUser;

  @PostConstruct
  void init() {
    adminUser = Optional.ofNullable(camundaBpmProperties.getAdminUser())
      .map(AdminUserProperty::init)
      .orElseThrow(fail("adminUser not configured!"));
  }

  @Override
  public void postProcessEngineBuild(final ProcessEngine processEngine) {
    requireNonNull(adminUser);

    final IdentityService identityService = processEngine.getIdentityService();
    final AuthorizationService authorizationService = processEngine.getAuthorizationService();

    if (userAlreadyExists(identityService, adminUser)) {
      return;
    }

    createUser(identityService, adminUser);

    // create group
    if (identityService.createGroupQuery().groupId(CAMUNDA_ADMIN).count() == 0) {
      Group camundaAdminGroup = identityService.newGroup(CAMUNDA_ADMIN);
      camundaAdminGroup.setName("Fluxnova BPM Administrators");
      camundaAdminGroup.setType(Groups.GROUP_TYPE_SYSTEM);
      identityService.saveGroup(camundaAdminGroup);
    }

    // create ADMIN authorizations on all built-in resources
    for (Resource resource : Resources.values()) {
      if (authorizationService.createAuthorizationQuery().groupIdIn(CAMUNDA_ADMIN).resourceType(resource).resourceId(ANY).count() == 0) {
        AuthorizationEntity userAdminAuth = new AuthorizationEntity(AUTH_TYPE_GRANT);
        userAdminAuth.setGroupId(CAMUNDA_ADMIN);
        userAdminAuth.setResource(resource);
        userAdminAuth.setResourceId(ANY);
        userAdminAuth.addPermission(ALL);
        authorizationService.saveAuthorization(userAdminAuth);
      }
    }

    identityService.createMembership(adminUser.getId(), CAMUNDA_ADMIN);
    LOG.creatingInitialAdminUser(adminUser);
  }

  static boolean userAlreadyExists(IdentityService identityService, User adminUser) {
    final User existingUser = identityService.createUserQuery()
      .userId(adminUser.getId())
      .singleResult();
    if (existingUser != null) {
      LOG.skipAdminUserCreation(existingUser);
      return true;
    }
    return false;
  }

  static User createUser(final IdentityService identityService, final User adminUser) {
    User newUser = identityService.newUser(adminUser.getId());
    BeanUtils.copyProperties(adminUser, newUser);
    identityService.saveUser(newUser);
    return newUser;
  }

}
