package org.finos.fluxnova.bpm.engine.variable;

/**
 * Encapsulates options for variable creation and storage.
 */
public class VariableOptions {

  protected boolean isTransient;
  protected boolean restricted;
  protected boolean skipJavaSerializationFormatCheck;
  protected boolean failIfNotExists;

  public VariableOptions(boolean isTransient, boolean restricted, boolean skipJavaSerializationFormatCheck) {
    this(isTransient, restricted, skipJavaSerializationFormatCheck, true);
  }

  public VariableOptions(boolean isTransient, boolean restricted, boolean skipJavaSerializationFormatCheck, boolean failIfNotExists) {
    this.isTransient = isTransient;
    this.restricted = restricted;
    this.skipJavaSerializationFormatCheck = skipJavaSerializationFormatCheck;
    this.failIfNotExists = failIfNotExists;
  }

  public boolean isTransient() {
    return isTransient;
  }

  public boolean isRestricted() {
    return restricted;
  }

  public boolean shouldSkipJavaSerializationFormatCheck() {
    return skipJavaSerializationFormatCheck;
  }

  public boolean shouldFailIfNotExists() {
    return failIfNotExists;
  }

  // Static factory method for convenience
  public static VariableOptions options(boolean isTransient, boolean restricted, boolean skipJavaSerializationFormatCheck) {
    return new VariableOptions(isTransient, restricted, skipJavaSerializationFormatCheck, true);
  }

  // Factory method with explicit failIfNotExists parameter
  public static VariableOptions options(boolean isTransient, boolean restricted, boolean skipJavaSerializationFormatCheck, boolean failIfNotExists) {
    return new VariableOptions(isTransient, restricted, skipJavaSerializationFormatCheck, failIfNotExists);
  }

  // Convenience factory method for the most common case (not skipping check)
  public static VariableOptions options(boolean isTransient, boolean restricted) {
    return new VariableOptions(isTransient, restricted, false, true);
  }
}

