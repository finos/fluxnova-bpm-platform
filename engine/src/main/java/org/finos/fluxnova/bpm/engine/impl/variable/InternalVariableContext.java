package org.finos.fluxnova.bpm.engine.impl.variable;

/**
 * Context holder for internal variable operations.
 * 
 * Manages thread-local flags to identify when variable operations are performed internally
 * (e.g., during write operations or read-only operations) as opposed to being triggered
 * by external callers. This allows variable processing logic to behave differently based
 * on the execution context.
 */
public class InternalVariableContext {
  private static final ThreadLocal<Boolean> INTERNAL_WRITE = ThreadLocal.withInitial(() -> false);
  private static final ThreadLocal<Boolean> INTERNAL_READ = ThreadLocal.withInitial(() -> false);

  public static void executeAsInternalWrite(Runnable runnable) {
    boolean previous = INTERNAL_WRITE.get();
    INTERNAL_WRITE.set(true);
    try {
      runnable.run();
    } finally {
      INTERNAL_WRITE.set(previous);
    }
  }

  public static boolean isInternalWrite() {
    return INTERNAL_WRITE.get();
  }

  public static void executeAsInternalRead(Runnable runnable) {
    boolean previous = INTERNAL_READ.get();
    INTERNAL_READ.set(true);
    try {
      runnable.run();
    } finally {
      INTERNAL_READ.set(previous);
    }
  }

  public static boolean isInternalRead() {
    return INTERNAL_READ.get();
  }
}
