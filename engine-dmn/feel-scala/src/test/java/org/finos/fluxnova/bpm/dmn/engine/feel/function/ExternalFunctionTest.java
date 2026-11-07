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
package org.finos.fluxnova.bpm.dmn.engine.feel.function;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.finos.fluxnova.bpm.dmn.engine.feel.helper.FeelRule;
import org.finos.fluxnova.bpm.dmn.feel.impl.FeelException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class ExternalFunctionTest {

  @RegisterExtension
  protected FeelRule feelRule = FeelRule.build();

  @Test
  public void shouldFailWhenUsingExternalFunction() {
    Throwable exception = assertThrows(FeelException.class, () ->

      // when
      feelRule.evaluateExpression("""
        {\s
          foo: function(x, y) external {\s
            java: {\s
                class: "java.lang.Math",\s
                method signature: "addExact(int, int)"\s
            }\s
          },
          bar: foo(5, 5)
        }.bar"""));
    assertThat(exception.getMessage(), containsString("External functions are disabled"));
  }

}
