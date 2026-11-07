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
package org.finos.fluxnova.bpm.engine.impl.variable.serializer;

import org.finos.fluxnova.bpm.engine.impl.persistence.entity.VariableInstanceEntity;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.finos.fluxnova.bpm.engine.variable.impl.value.NullValueImpl;
import org.finos.fluxnova.bpm.engine.variable.impl.value.UntypedValueImpl;
import org.finos.fluxnova.bpm.engine.variable.type.ValueType;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;

/**
 * Used to serialize untyped null values.
 *
 * @author Daniel Meyer
 * @author Tom Baeyens
 */
public class NullValueSerializer extends AbstractTypedValueSerializer<NullValueImpl> {

  public NullValueSerializer() {
    super(ValueType.NULL);
  }

  public String getName() {
    return ValueType.NULL.getName().toLowerCase();
  }

  public NullValueImpl convertToTypedValue(UntypedValueImpl untypedValue) {
    return Variables.nullValue(untypedValue.isTransient(), untypedValue.isRestricted());
  }

  public void writeValue(NullValueImpl value, ValueFields valueFields) {
    if (valueFields instanceof VariableInstanceEntity) {
      ((VariableInstanceEntity) valueFields).setRestricted(value.isRestricted());
    }
  }

  public NullValueImpl readValue(ValueFields valueFields, boolean deserialize, boolean asTransientValue) {
    boolean restricted = false;
    if (valueFields instanceof VariableInstanceEntity) {
      restricted = ((VariableInstanceEntity) valueFields).isRestricted();
    }
    return Variables.nullValue(asTransientValue, restricted);
  }

  protected boolean canWriteValue(TypedValue value) {
    return value.getValue() == null;
  }

}
