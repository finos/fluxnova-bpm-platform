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
package org.finos.fluxnova.bpm.model.cmmn.impl.instance.fluxnova;

import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_SOURCE;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_SOURCE_EXPRESSION;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_TARGET;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_VARIABLES;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ELEMENT_OUT;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;

import org.finos.fluxnova.bpm.model.cmmn.impl.instance.CmmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaOut;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;

/**
 * @author Sebastian Menski
 * @author Roman Smirnov
 *
 */
public class FluxnovaOutImpl extends CmmnModelElementInstanceImpl implements FluxnovaOut {

  protected static Attribute<String> camundaSourceAttribute;
  protected static Attribute<String> camundaSourceExpressionAttribute;
  protected static Attribute<String> camundaVariablesAttribute;
  protected static Attribute<String> camundaTargetAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaOut.class, CAMUNDA_ELEMENT_OUT)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaOut>() {
        public FluxnovaOut newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaOutImpl(instanceContext);
        }
      });

    camundaSourceAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_SOURCE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaSourceExpressionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_SOURCE_EXPRESSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaVariablesAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_VARIABLES)
      .namespace(CAMUNDA_NS)
      .build();

    camundaTargetAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_TARGET)
      .namespace(CAMUNDA_NS)
      .build();

    typeBuilder.build();
  }

  public FluxnovaOutImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFluxnovaSource() {
    return camundaSourceAttribute.getValue(this);
  }

  public void setFluxnovaSource(String camundaSource) {
    camundaSourceAttribute.setValue(this, camundaSource);
  }

  public String getFluxnovaSourceExpression() {
    return camundaSourceExpressionAttribute.getValue(this);
  }

  public void setFluxnovaSourceExpression(String camundaSourceExpression) {
    camundaSourceExpressionAttribute.setValue(this, camundaSourceExpression);
  }

  public String getFluxnovaVariables() {
    return camundaVariablesAttribute.getValue(this);
  }

  public void setFluxnovaVariables(String camundaVariables) {
    camundaVariablesAttribute.setValue(this, camundaVariables);
  }

  public String getFluxnovaTarget() {
    return camundaTargetAttribute.getValue(this);
  }

  public void setFluxnovaTarget(String camundaTarget) {
    camundaTargetAttribute.setValue(this, camundaTarget);
  }

}
