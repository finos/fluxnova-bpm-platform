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
package org.finos.fluxnova.bpm.engine.rest.mapper;

import java.text.SimpleDateFormat;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

import org.finos.fluxnova.bpm.engine.rest.hal.Hal;

import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;

@Provider
@Produces({MediaType.APPLICATION_JSON, Hal.APPLICATION_HAL_JSON})
public class JacksonConfigurator implements ContextResolver<ObjectMapper> {

  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXX";
  public static String dateFormatString = DEFAULT_DATE_FORMAT;

  public static JsonMapper configureObjectMapper() {
    SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
    return JsonMapper.builder()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
            .defaultDateFormat(dateFormat)
            .build();
  }

  @Override
  public ObjectMapper getContext(Class<?> clazz) {
    return configureObjectMapper();
  }

  public static void setDateFormatString(String dateFormatString) {
    JacksonConfigurator.dateFormatString = dateFormatString;
  }

}
