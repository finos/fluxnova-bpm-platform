package org.finos.fluxnova.bpm.engine.configuration;

import java.util.Date;

/**
 * <p>A process configuration entry: a key/value pair which is either global or
 * scoped to a single tenant.</p>
 */
public interface Configuration {

  /** Lifecycle status of an entry which is currently in effect. */
  String STATUS_ACTIVE = "ACTIVE";

  /** Lifecycle status of an entry which has been soft-deleted. */
  String STATUS_DELETED = "DELETED";

  /** Lifecycle status of an entry which has been superseded by a newer version. */
  String STATUS_INACTIVE = "INACTIVE";

  /** @return the id of the configuration entry */
  String getId();

  /** @return the configuration key */
  String getConfigKey();

  /** @return the id of the tenant this entry belongs to, or {@code null} for a global entry */
  String getTenantId();

  /** @return the configuration value */
  String getConfigValue();

  /** @return the version of this entry, starting at 1 */
  int getVersion();

  /**
   * @return the lifecycle status: {@link #STATUS_ACTIVE}, {@link #STATUS_INACTIVE}
   *         or {@link #STATUS_DELETED}
   */
  String getStatus();

  /** @return the id of the user who created this entry */
  String getCreatedBy();

  /** @return the time this entry was created */
  Date getCreatedAt();

  /** @return the id of the user who last updated this entry */
  String getUpdatedBy();

  /** @return the time this entry was last updated */
  Date getUpdatedAt();

}
