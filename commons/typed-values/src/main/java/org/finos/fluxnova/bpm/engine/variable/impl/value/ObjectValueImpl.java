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
package org.finos.fluxnova.bpm.engine.variable.impl.value;

import org.finos.fluxnova.bpm.engine.variable.type.SerializableValueType;
import org.finos.fluxnova.bpm.engine.variable.type.ValueType;
import org.finos.fluxnova.bpm.engine.variable.value.ObjectValue;

/**
 * @author Daniel Meyer
 *
 */
public class ObjectValueImpl extends AbstractTypedValue<Object> implements ObjectValue {

  private static final long serialVersionUID = 1L;

  protected String objectTypeName;

  protected String serializationDataFormat;
  protected String serializedValue;
  protected boolean isDeserialized;

  public ObjectValueImpl(
      Object deserializedValue,
      String serializedValue,
      String serializationDataFormat,
      String objectTypeName,
      boolean isDeserialized) {

    super(deserializedValue, ValueType.OBJECT);

    this.serializedValue = serializedValue;
    this.serializationDataFormat = serializationDataFormat;
    this.objectTypeName = objectTypeName;
    this.isDeserialized = isDeserialized;
  }

  public ObjectValueImpl(Object value) {
    this(value, null, null, null, true);
  }

  public ObjectValueImpl(Object value, boolean isTransient) {
    this(value, null, null, null, true);
    this.isTransient = isTransient;
  }

  public ObjectValueImpl(Object value, boolean isTransient, boolean restricted) {
    this(value, isTransient);
    this.restricted = restricted;
  }

  public String getSerializationDataFormat() {
    return serializationDataFormat;
  }

  public void setSerializationDataFormat(String serializationDataFormat) {
    this.serializationDataFormat = serializationDataFormat;
  }

  public String getObjectTypeName() {
    return objectTypeName;
  }

  public void setObjectTypeName(String objectTypeName) {
    this.objectTypeName = objectTypeName;
  }

  public String getValueSerialized() {
    return serializedValue;
  }

  public void setSerializedValue(String serializedValue) {
    this.serializedValue = serializedValue;
  }

  public boolean isDeserialized() {
    return isDeserialized;
  }

  @Override
  public Object getValue() {
    if(isDeserialized) {
      return super.getValue();
    }
    else {
      throw new IllegalStateException("Object is not deserialized.");
    }
  }

  @SuppressWarnings("unchecked")
  public <T> T getValue(Class<T> type) {
    Object value = getValue();
    if(type.isAssignableFrom(value.getClass())) {
      return (T) value;
    }
    else {
      throw new IllegalArgumentException("Value '"+value+"' is not of type '"+type+"'.");
    }
  }

  public Class<?> getObjectType() {
    Object value = getValue();

    if(value == null) {
      return null;
    }
    else {
      return value.getClass();
    }
  }

  @Override
  public SerializableValueType getType() {
    return (SerializableValueType) super.getType();
  }

  public void setTransient(boolean isTransient) {
    this.isTransient = isTransient;
  }

  @Override
  public String toString() {
    return "ObjectValue ["
        + "value=" + value
        + ", isDeserialized=" + isDeserialized
        + ", serializationDataFormat=" + serializationDataFormat
        + ", objectTypeName=" + objectTypeName
        + ", serializedValue="+ (serializedValue != null ? (serializedValue.length() + " chars") : null)
        + ", isTransient=" + isTransient
          + ", restricted=" + restricted
        + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ObjectValueImpl other = (ObjectValueImpl) obj;
    if (isDeserialized != other.isDeserialized) {
      return false;
    }
    if (isDeserialized) {
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false;
    } else {
      if (serializedValue == null) {
        if (other.serializedValue != null)
          return false;
      } else if (!serializedValue.equals(other.serializedValue))
        return false;
    }
    if (serializationDataFormat == null) {
      if (other.serializationDataFormat != null)
        return false;
    } else if (!serializationDataFormat.equals(other.serializationDataFormat))
      return false;
    if (objectTypeName == null) {
      if (other.objectTypeName != null)
        return false;
    } else if (!objectTypeName.equals(other.objectTypeName))
      return false;
    if (isTransient != other.isTransient()) {
      return false;
    }
    if (restricted != other.restricted)
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (isDeserialized ? 1 : 0);
    if (isDeserialized) {
      result = prime * result + ((value == null) ? 0 : value.hashCode());
    } else {
      result = prime * result + ((serializedValue == null) ? 0 : serializedValue.hashCode());
    }
    result = prime * result + ((serializationDataFormat == null) ? 0 : serializationDataFormat.hashCode());
    result = prime * result + ((objectTypeName == null) ? 0 : objectTypeName.hashCode());
    result = prime * result + (isTransient ? 1 : 0);
    result = prime * result + (restricted ? 1 : 0);
    return result;
  }
}
