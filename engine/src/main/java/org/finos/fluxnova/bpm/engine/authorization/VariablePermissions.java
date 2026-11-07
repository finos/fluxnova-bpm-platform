package org.finos.fluxnova.bpm.engine.authorization;

public enum VariablePermissions implements Permission {

    /** The none permission means 'no action', 'doing nothing'.
     * It does not mean that no permissions are granted. */
    NONE("NONE", 0),

    /**
     * Indicates that  all interactions are permitted.
     * If ALL is revoked it means that the user is not permitted
     * to do everything, which means that at least one permission
     * is revoked. This does not implicate that all individual
     * permissions are revoked.
     *
     * Example: If the UPDATE permission is revoked then the ALL
     * permission is revoked as well, because the user is not authorized
     * to execute all actions anymore.
     */
    ALL("ALL", Integer.MAX_VALUE),

    /** Indicates that READ_RESTRICTED interactions are permitted. */
    READ_RESTRICTED("READ_RESTRICTED", 2),

    /** Indicates that READ_HISTORY_RESTRICTED interactions are permitted. */
    READ_HISTORY_RESTRICTED("READ_HISTORY_RESTRICTED", 32),

    /** Indicates that UPDATE_RESTRICTED interactions are permitted. */
    UPDATE_RESTRICTED("UPDATE_RESTRICTED", 4),

    /** Indicates that CREATE_RESTRICTED interactions are permitted. */
    CREATE_RESTRICTED("CREATE_RESTRICTED", 8),

    /** Indicates that DELETE_RESTRICTED interactions are permitted. */
    DELETE_RESTRICTED("DELETE_RESTRICTED", 16),

    /** Indicates that DELETE_HISTORY_RESTRICTED interactions are permitted. */
    DELETE_HISTORY_RESTRICTED("DELETE_HISTORY_RESTRICTED", 64);

    private static final Resource[] RESOURCES = new Resource[] { Resources.VARIABLE };
    private String name;
    private int id;

    private VariablePermissions (String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return id;
    }

    @Override
    public Resource[] getTypes() {
        return RESOURCES;
    }
}
