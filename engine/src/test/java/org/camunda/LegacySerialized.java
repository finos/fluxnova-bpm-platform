package org.camunda;

import java.io.Serializable;

/**
 * Test helper that simulates a legacy serialized class in the org.camunda namespace.
 * Fields are kept simple and compatible with the new-package counterpart.
 */
public class LegacySerialized implements Serializable {
    private static final long serialVersionUID = 1L;
    public int value;

    public LegacySerialized() {
    }

    public LegacySerialized(int value) {
        this.value = value;
    }
}

