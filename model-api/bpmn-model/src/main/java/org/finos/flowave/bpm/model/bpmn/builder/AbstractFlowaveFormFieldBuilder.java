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
package org.finos.flowave.bpm.model.bpmn.builder;

import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.bpm.model.bpmn.instance.BaseElement;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormField;

/**
 * @author Kristin Polenz
 *
 */
public class AbstractFlowaveFormFieldBuilder<P, B extends AbstractFlowaveFormFieldBuilder<P, B>> 
  extends AbstractBpmnModelElementBuilder<B, FlowaveFormField> {

  protected BaseElement parent;

  protected AbstractFlowaveFormFieldBuilder(BpmnModelInstance modelInstance, BaseElement parent, FlowaveFormField element, Class<?> selfType) {
    super(modelInstance, element, selfType);
    this.parent = parent;
  }
  

  /**
   * Sets the form field id.
   *
   * @param id the form field id
   * @return  the builder object
   */
  public B flowaveId(String id) {
    element.setFlowaveId(id);
    return myself;
  }

  /**
   * Sets form field label.
   *
   * @param label the form field label
   * @return  the builder object
   */
  public B flowaveLabel(String label) {
    element.setFlowaveLabel(label);;
    return myself;
  }

  /**
   * Sets the form field type.
   *
   * @param type the form field type
   * @return the builder object
   */
  public B flowaveType(String type) {
    element.setFlowaveType(type);
    return myself;
  }

  /**
   * Sets the form field default value.
   *
   * @param defaultValue the form field default value
   * @return the builder object
   */
  public B flowaveDefaultValue(String defaultValue) {
    element.setFlowaveDefaultValue(defaultValue);
    return myself;
  }

  /**
   * Finishes the building of a form field.
   *
   * @return the parent activity builder
   */
  @SuppressWarnings({ "unchecked" })
  public P flowaveFormFieldDone() {
    return (P) parent.builder();
  }
}
