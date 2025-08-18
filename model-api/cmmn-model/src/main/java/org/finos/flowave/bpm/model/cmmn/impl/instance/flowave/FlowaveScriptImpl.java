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
package org.finos.flowave.bpm.model.cmmn.impl.instance.flowave;

import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_RESOURCE;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_SCRIPT_FORMAT;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ELEMENT_SCRIPT;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;

import org.finos.flowave.bpm.model.cmmn.impl.instance.CmmnModelElementInstanceImpl;
import org.finos.flowave.bpm.model.cmmn.instance.flowave.FlowaveScript;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;

/**
 * @author Roman Smirnov
 *
 */
public class FlowaveScriptImpl extends CmmnModelElementInstanceImpl implements FlowaveScript {

  protected static Attribute<String> camundaScriptFormatAttribute;
  protected static Attribute<String> camundaResourceAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveScript.class, CAMUNDA_ELEMENT_SCRIPT)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveScript>() {
        public FlowaveScript newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveScriptImpl(instanceContext);
        }
      });

    camundaScriptFormatAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_SCRIPT_FORMAT)
        .namespace(CAMUNDA_NS)
        .build();

    camundaResourceAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_RESOURCE)
        .namespace(CAMUNDA_NS)
        .build();

    typeBuilder.build();
  }

  public FlowaveScriptImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFlowaveScriptFormat() {
    return camundaScriptFormatAttribute.getValue(this);
  }

  public void setFlowaveScriptFormat(String scriptFormat) {
    camundaScriptFormatAttribute.setValue(this, scriptFormat);
  }

  public String getFlowaveResource() {
    return camundaResourceAttribute.getValue(this);
  }

  public void setFlowaveResoure(String resource) {
    camundaResourceAttribute.setValue(this, resource);
  }

}
