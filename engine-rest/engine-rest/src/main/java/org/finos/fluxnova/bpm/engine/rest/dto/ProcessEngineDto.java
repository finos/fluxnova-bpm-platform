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
package org.finos.fluxnova.bpm.engine.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ProcessEngineDto {

  private String name;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String displayName;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String group;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String groupDisplayName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getGroupDisplayName() {
    return groupDisplayName;
  }

  public void setGroupDisplayName(String groupDisplayName) {
    this.groupDisplayName = groupDisplayName;
  }

}
