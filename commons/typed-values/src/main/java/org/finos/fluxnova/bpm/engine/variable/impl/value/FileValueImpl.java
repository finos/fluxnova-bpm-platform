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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.finos.fluxnova.bpm.engine.variable.type.FileValueType;
import org.finos.fluxnova.bpm.engine.variable.type.ValueType;
import org.finos.fluxnova.bpm.engine.variable.value.FileValue;

/**
 * @author Ronny Bräunlich
 * @since 7.4
 *
 */
public class FileValueImpl implements FileValue {

  private static final long serialVersionUID = 1L;
  protected String mimeType;
  protected String filename;
  protected byte[] value;
  protected FileValueType type;
  protected String encoding;
  protected boolean isTransient;
  protected boolean restricted;

  public FileValueImpl(byte[] value, FileValueType type, String filename, String mimeType, String encoding) {
    this.value = value;
    this.type = type;
    this.filename = filename;
    this.mimeType = mimeType;
    this.encoding = encoding;
  }

  public FileValueImpl(FileValueType type, String filename) {
    this(null, type, filename, null, null);
  }

  @Override
  public String getFilename() {
    return filename;
  }

  @Override
  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public void setValue(byte[] bytes) {
    this.value = bytes;
  }

  @Override
  public InputStream getValue() {
    if (value == null) {
      return null;
    }
    return new ByteArrayInputStream(value);
  }

  @Override
  public ValueType getType() {
    return type;
  }

  public void setEncoding(String encoding) {
    this.encoding = encoding;
  }

  public void setEncoding(Charset encoding) {
    this.encoding = encoding.name();
  }

  @Override
  public Charset getEncodingAsCharset() {
    if (encoding == null) {
      return null;
    }
    return Charset.forName(encoding);
  }

  @Override
  public String getEncoding() {
    return encoding;
  }

  /**
   * Get the byte array directly without wrapping it inside a stream to evade
   * not needed wrapping. This method is intended for the internal API, which
   * needs the byte array anyways.
   */
  public byte[] getByteArray() {
    return value;
  }

  @Override
  public String toString() {
    return "FileValueImpl [mimeType=" + mimeType + ", filename=" + filename + ", type=" + type + ", isTransient=" + isTransient + ", restricted=" + restricted + "]";
  }

  @Override
  public boolean isTransient() {
    return isTransient;
  }

  public void setTransient(boolean isTransient) {
    this.isTransient = isTransient;
  }

  @Override
  public boolean isRestricted() {
    return restricted;
  }

  public void setRestricted(boolean restricted) {
    this.restricted = restricted;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FileValueImpl other = (FileValueImpl) obj;
    if (filename == null) {
      if (other.filename != null)
        return false;
    } else if (!filename.equals(other.filename))
      return false;
    if (mimeType == null) {
      if (other.mimeType != null)
        return false;
    } else if (!mimeType.equals(other.mimeType))
      return false;
    if (encoding == null) {
      if (other.encoding != null)
        return false;
    } else if (!encoding.equals(other.encoding))
      return false;
    if (!java.util.Arrays.equals(value, other.value))
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
    result = prime * result + ((filename == null) ? 0 : filename.hashCode());
    result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
    result = prime * result + ((encoding == null) ? 0 : encoding.hashCode());
    result = prime * result + java.util.Arrays.hashCode(value);
    result = prime * result + (isTransient ? 1 : 0);
    result = prime * result + (restricted ? 1 : 0);
    return result;
  }
}
