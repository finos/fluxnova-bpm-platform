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
package org.finos.fluxnova.bpm.client.rule;

import org.junit.jupiter.api.extension.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JUnit 5 extension that chains multiple extensions together in order
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

  /** Alias for outerExtension() for backward compatibility */
  public static ChainedExtension outerRule(Object extension) {
    return outerExtension(extension);
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
    // Execute in reverse order
    for (int i = extensions.size() - 1; i >= 0; i--) {
      Object extension = extensions.get(i);
      if (extension instanceof AfterEachCallback) {
        ((AfterEachCallback) extension).afterEach(context);
      }
    }
  }
}

