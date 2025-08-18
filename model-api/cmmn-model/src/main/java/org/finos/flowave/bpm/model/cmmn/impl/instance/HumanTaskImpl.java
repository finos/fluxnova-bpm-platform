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

import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_ASSIGNEE;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_CANDIDATE_GROUPS;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_CANDIDATE_USERS;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_DUE_DATE;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_FOLLOW_UP_DATE;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_FORM_KEY;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_PRIORITY;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CMMN11_NS;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CMMN_ATTRIBUTE_PERFORMER_REF;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CMMN_ELEMENT_HUMAN_TASK;

import java.util.Collection;
import java.util.List;

import org.finos.flowave.bpm.model.cmmn.instance.HumanTask;
import org.finos.flowave.bpm.model.cmmn.instance.PlanningTable;
import org.finos.flowave.bpm.model.cmmn.instance.Role;
import org.finos.flowave.bpm.model.cmmn.instance.Task;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.impl.util.StringUtil;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;
import org.finos.flowave.bpm.model.xml.type.child.ChildElement;
import org.finos.flowave.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;
import org.finos.flowave.bpm.model.xml.type.reference.AttributeReference;

/**
 * @author Roman Smirnov
 *
 */
public class HumanTaskImpl extends TaskImpl implements HumanTask {

  protected static AttributeReference<Role> performerRefAttribute;

  // cmmn 1.0
  @Deprecated
  protected static ChildElementCollection<PlanningTable> planningTableCollection;

  // cmmn 1.1
  protected static ChildElement<PlanningTable> planningTableChild;

  /** camunda extensions */
  protected static Attribute<String> camundaAssigneeAttribute;
  protected static Attribute<String> camundaCandidateGroupsAttribute;
  protected static Attribute<String> camundaCandidateUsersAttribute;
  protected static Attribute<String> camundaDueDateAttribute;
  protected static Attribute<String> camundaFollowUpDateAttribute;
  protected static Attribute<String> camundaFormKeyAttribute;
  protected static Attribute<String> camundaPriorityAttribute;

  public HumanTaskImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Role getPerformer() {
    return performerRefAttribute.getReferenceTargetElement(this);
  }

  public void setPerformer(Role performer) {
    performerRefAttribute.setReferenceTargetElement(this, performer);
  }

  public Collection<PlanningTable> getPlanningTables() {
    return planningTableCollection.get(this);
  }

  public PlanningTable getPlanningTable() {
    return planningTableChild.getChild(this);
  }

  public void setPlanningTable(PlanningTable planningTable) {
    planningTableChild.setChild(this, planningTable);
  }

  /** camunda extensions */

  public String getFlowaveAssignee() {
    return camundaAssigneeAttribute.getValue(this);
  }

  public void setFlowaveAssignee(String camundaAssignee) {
    camundaAssigneeAttribute.setValue(this, camundaAssignee);
  }

  public String getFlowaveCandidateGroups() {
    return camundaCandidateGroupsAttribute.getValue(this);
  }

  public void setFlowaveCandidateGroups(String camundaCandidateGroups) {
    camundaCandidateGroupsAttribute.setValue(this, camundaCandidateGroups);
  }

  public List<String> getFlowaveCandidateGroupsList() {
    String candidateGroups = camundaCandidateGroupsAttribute.getValue(this);
    return StringUtil.splitCommaSeparatedList(candidateGroups);
  }

  public void setFlowaveCandidateGroupsList(List<String> camundaCandidateGroupsList) {
    String candidateGroups = StringUtil.joinCommaSeparatedList(camundaCandidateGroupsList);
    camundaCandidateGroupsAttribute.setValue(this, candidateGroups);
  }

  public String getFlowaveCandidateUsers() {
    return camundaCandidateUsersAttribute.getValue(this);
  }

  public void setFlowaveCandidateUsers(String camundaCandidateUsers) {
    camundaCandidateUsersAttribute.setValue(this, camundaCandidateUsers);
  }

  public List<String> getFlowaveCandidateUsersList() {
    String candidateUsers = camundaCandidateUsersAttribute.getValue(this);
    return StringUtil.splitCommaSeparatedList(candidateUsers);
  }

  public void setFlowaveCandidateUsersList(List<String> camundaCandidateUsersList) {
    String candidateUsers = StringUtil.joinCommaSeparatedList(camundaCandidateUsersList);
    camundaCandidateUsersAttribute.setValue(this, candidateUsers);
  }

  public String getFlowaveDueDate() {
    return camundaDueDateAttribute.getValue(this);
  }

  public void setFlowaveDueDate(String camundaDueDate) {
    camundaDueDateAttribute.setValue(this, camundaDueDate);
  }

  public String getFlowaveFollowUpDate() {
    return camundaFollowUpDateAttribute.getValue(this);
  }

  public void setFlowaveFollowUpDate(String camundaFollowUpDate) {
    camundaFollowUpDateAttribute.setValue(this, camundaFollowUpDate);
  }

  public String getFlowaveFormKey() {
    return camundaFormKeyAttribute.getValue(this);
  }

  public void setFlowaveFormKey(String camundaFormKey) {
    camundaFormKeyAttribute.setValue(this, camundaFormKey);
  }

  public String getFlowavePriority() {
    return camundaPriorityAttribute.getValue(this);
  }

  public void setFlowavePriority(String camundaPriority) {
    camundaPriorityAttribute.setValue(this, camundaPriority);
  }

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(HumanTask.class, CMMN_ELEMENT_HUMAN_TASK)
        .namespaceUri(CMMN11_NS)
        .extendsType(Task.class)
        .instanceProvider(new ModelTypeInstanceProvider<HumanTask>() {
          public HumanTask newInstance(ModelTypeInstanceContext instanceContext) {
            return new HumanTaskImpl(instanceContext);
          }
        });

    performerRefAttribute = typeBuilder.stringAttribute(CMMN_ATTRIBUTE_PERFORMER_REF)
        .idAttributeReference(Role.class)
        .build();

    /** camunda extensions */

    camundaAssigneeAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_ASSIGNEE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaCandidateGroupsAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_CANDIDATE_GROUPS)
      .namespace(CAMUNDA_NS)
      .build();

    camundaCandidateUsersAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_CANDIDATE_USERS)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDueDateAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DUE_DATE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaFollowUpDateAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_FOLLOW_UP_DATE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaFormKeyAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_FORM_KEY)
      .namespace(CAMUNDA_NS)
      .build();

    camundaPriorityAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_PRIORITY)
      .namespace(CAMUNDA_NS)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    planningTableCollection = sequenceBuilder.elementCollection(PlanningTable.class)
        .build();

    planningTableChild = sequenceBuilder.element(PlanningTable.class)
        .minOccurs(0)
        .maxOccurs(1)
        .build();

    typeBuilder.build();
  }

}
