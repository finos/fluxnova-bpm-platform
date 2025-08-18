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
package org.finos.flowave.bpm.model.cmmn.impl.instance;

import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_CASE_BINDING;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_CASE_VERSION;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_CASE_TENANT_ID;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CMMN11_NS;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CMMN_ATTRIBUTE_CASE_REF;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CMMN_ELEMENT_CASE_TASK;

import java.util.Collection;

import org.finos.flowave.bpm.model.cmmn.instance.CaseRefExpression;
import org.finos.flowave.bpm.model.cmmn.instance.CaseTask;
import org.finos.flowave.bpm.model.cmmn.instance.ParameterMapping;
import org.finos.flowave.bpm.model.cmmn.instance.Task;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;
import org.finos.flowave.bpm.model.xml.type.child.ChildElement;
import org.finos.flowave.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

/**
 * @author Roman Smirnov
 *
 */
public class CaseTaskImpl extends TaskImpl implements CaseTask {

  protected static Attribute<String> caseRefAttribute;
  protected static ChildElementCollection<ParameterMapping> parameterMappingCollection;

  // cmmn 1.1
  protected static ChildElement<CaseRefExpression> caseRefExpressionChild;

  protected static Attribute<String> camundaCaseBindingAttribute;
  protected static Attribute<String> camundaCaseVersionAttribute;
  protected static Attribute<String> camundaCaseTenantIdAttribute;

  public CaseTaskImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getCase() {
    return caseRefAttribute.getValue(this);
  }

  public void setCase(String caseInstance) {
    caseRefAttribute.setValue(this, caseInstance);
  }

  public CaseRefExpression getCaseExpression() {
    return caseRefExpressionChild.getChild(this);
  }

  public void setCaseExpression(CaseRefExpression caseExpression) {
    caseRefExpressionChild.setChild(this, caseExpression);
  }

  public Collection<ParameterMapping> getParameterMappings() {
    return parameterMappingCollection.get(this);
  }

  public String getFlowaveCaseBinding() {
    return camundaCaseBindingAttribute.getValue(this);
  }

  public void setFlowaveCaseBinding(String camundaCaseBinding) {
    camundaCaseBindingAttribute.setValue(this, camundaCaseBinding);
  }

  public String getFlowaveCaseVersion() {
    return camundaCaseVersionAttribute.getValue(this);
  }

  public void setFlowaveCaseVersion(String camundaCaseVersion) {
    camundaCaseVersionAttribute.setValue(this, camundaCaseVersion);
  }

  public String getFlowaveCaseTenantId() {
    return camundaCaseTenantIdAttribute.getValue(this);
  }

  public void setFlowaveCaseTenantId(String camundaCaseTenantId) {
    camundaCaseTenantIdAttribute.setValue(this, camundaCaseTenantId);
  }

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(CaseTask.class, CMMN_ELEMENT_CASE_TASK)
        .extendsType(Task.class)
        .namespaceUri(CMMN11_NS)
        .instanceProvider(new ModelTypeInstanceProvider<CaseTask>() {
          public CaseTask newInstance(ModelTypeInstanceContext instanceContext) {
            return new CaseTaskImpl(instanceContext);
          }
        });

    caseRefAttribute = typeBuilder.stringAttribute(CMMN_ATTRIBUTE_CASE_REF)
        .build();

    /** camunda extensions */

    camundaCaseBindingAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_CASE_BINDING)
      .namespace(CAMUNDA_NS)
      .build();

    camundaCaseVersionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_CASE_VERSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaCaseTenantIdAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_CASE_TENANT_ID)
        .namespace(CAMUNDA_NS)
        .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    parameterMappingCollection = sequenceBuilder.elementCollection(ParameterMapping.class)
        .build();

    caseRefExpressionChild = sequenceBuilder.element(CaseRefExpression.class)
        .build();

    typeBuilder.build();
  }

}
