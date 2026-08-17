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
package org.finos.fluxnova.bpm.engine.impl.cmd;

import java.util.Map;

import org.finos.fluxnova.bpm.engine.history.UserOperationLogEntry;
import org.finos.fluxnova.bpm.engine.impl.core.variable.scope.AbstractVariableScope;
import org.finos.fluxnova.bpm.engine.variable.VariableOptions;

/**
 * @author Stefan Hentschel.
 */
public abstract class AbstractSetVariableCmd extends AbstractVariableCmd {

  private static final long serialVersionUID = 1L;

  protected Map<String, ? extends Object> variables;

  protected boolean skipJavaSerializationFormatCheck;
  protected boolean restricted;
  protected VariableOptions variableOptions;

  public AbstractSetVariableCmd(String entityId, Map<String, ? extends Object> variables, boolean isLocal) {
    this(entityId, variables, isLocal, false);
  }

  public AbstractSetVariableCmd(String entityId, Map<String, ? extends Object> variables, boolean isLocal, boolean skipJavaSerializationFormatCheck) {
    this(entityId, variables, isLocal, new VariableOptions(false, false, skipJavaSerializationFormatCheck, true));
  }

  public AbstractSetVariableCmd(String entityId, Map<String, ? extends Object> variables, boolean isLocal, VariableOptions options) {
    super(entityId, isLocal);
    this.variables = variables;
    this.variableOptions = options;
    // Maintain backward compatibility with direct field access
    this.skipJavaSerializationFormatCheck = options.shouldSkipJavaSerializationFormatCheck();
    this.restricted = options.isRestricted();
  }

  protected void executeOperation(AbstractVariableScope scope) {
    if (isLocal) {
      scope.setVariablesLocalInternal(variables, skipJavaSerializationFormatCheck, restricted);
    } else {
      scope.setVariablesInternal(variables, skipJavaSerializationFormatCheck, restricted);
    }
  }

  protected String getLogEntryOperation() {
    return UserOperationLogEntry.OPERATION_TYPE_SET_VARIABLE;
  }

  protected VariableOptions getVariableOptions() {
    return variableOptions;
  }
}
