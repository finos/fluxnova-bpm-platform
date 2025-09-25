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
package org.finos.fluxnova.bpm.pa;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.finos.fluxnova.bpm.admin.impl.web.SetupResource;
import org.finos.fluxnova.bpm.application.PostDeploy;
import org.finos.fluxnova.bpm.application.ProcessApplication;
import org.finos.fluxnova.bpm.application.impl.ServletProcessApplication;
import org.finos.fluxnova.bpm.engine.CaseService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.impl.ProcessEngineImpl;
import org.finos.fluxnova.bpm.engine.impl.util.ClockUtil;
import org.finos.fluxnova.bpm.engine.rest.dto.identity.UserCredentialsDto;
import org.finos.fluxnova.bpm.engine.rest.dto.identity.UserDto;
import org.finos.fluxnova.bpm.engine.rest.dto.identity.UserProfileDto;
import org.finos.fluxnova.bpm.engine.runtime.CaseExecutionQuery;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;

/**
 *
 * @author nico.rehwaldt
 */
@ProcessApplication
public class TestProcessApplication extends ServletProcessApplication {

}
