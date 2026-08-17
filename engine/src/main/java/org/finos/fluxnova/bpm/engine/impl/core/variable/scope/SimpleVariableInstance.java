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
package org.finos.fluxnova.bpm.engine.impl.core.variable.scope;

import org.finos.fluxnova.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;
import org.finos.fluxnova.bpm.engine.variable.impl.value.AbstractTypedValue;
import org.finos.fluxnova.bpm.engine.variable.impl.value.FileValueImpl;

/**
 * @author Daniel Meyer
 * @author Roman Smirnov
 * @author Sebastian Menski
 *
 */
public class SimpleVariableInstance implements CoreVariableInstance {

  protected String name;
  protected TypedValue value;
  protected boolean restricted;

  public SimpleVariableInstance(String name, TypedValue value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public TypedValue getTypedValue(boolean deserialize) {
    if (value != null && restricted) {
      applyRestricted(value);
    }
    return value;
  }

  protected void applyRestricted(TypedValue typedValue) {
    if (typedValue instanceof AbstractTypedValue<?>) {
      ((AbstractTypedValue<?>) typedValue).setRestricted(true);
    } else if (typedValue instanceof FileValueImpl) {
      ((FileValueImpl) typedValue).setRestricted(true);
    }
  }
  public void setValue(TypedValue value) {
    this.value = value;
  }

  public boolean isRestricted() {
    return restricted;
  }

  public void setRestricted(boolean restricted) {
    this.restricted = restricted;
  }

  public static class SimpleVariableInstanceFactory implements VariableInstanceFactory<SimpleVariableInstance> {

    public static final SimpleVariableInstanceFactory INSTANCE = new SimpleVariableInstanceFactory();

    @Override
    public SimpleVariableInstance build(String name, TypedValue value, boolean isTransient, boolean restricted) {
      SimpleVariableInstance instance = new SimpleVariableInstance(name, value);
      instance.setRestricted(restricted);
      return instance;
    }

  }

}
