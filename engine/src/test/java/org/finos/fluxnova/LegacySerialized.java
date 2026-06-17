package org.finos.fluxnova;

import java.io.Serializable;

/**
 * Target class in the new namespace. Structure matches the legacy class so
 * deserialization can succeed after remapping.
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

