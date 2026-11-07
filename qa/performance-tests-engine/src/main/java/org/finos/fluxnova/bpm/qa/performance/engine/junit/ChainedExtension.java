package org.finos.fluxnova.bpm.qa.performance.engine.junit;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * JUnit 5 replacement for JUnit 4's RuleChain.
 * Allows chaining multiple extensions in a specific order.
 */
public class ChainedExtension implements BeforeEachCallback, AfterEachCallback {

  private final List<Object> extensions = new ArrayList<>();

  private ChainedExtension() {
  }

  public static ChainedExtension outerExtension(Object extension) {
    ChainedExtension chain = new ChainedExtension();
    chain.extensions.add(extension);
    return chain;
  }

  public ChainedExtension around(Object extension) {
    extensions.add(extension);
    return this;
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    for (Object extension : extensions) {
      if (extension instanceof BeforeEachCallback) {
        ((BeforeEachCallback) extension).beforeEach(context);
      }
    }
  }

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    for (int i = extensions.size() - 1; i >= 0; i--) {
      Object extension = extensions.get(i);
      if (extension instanceof AfterEachCallback) {
        ((AfterEachCallback) extension).afterEach(context);
      }
    }
  }
}

