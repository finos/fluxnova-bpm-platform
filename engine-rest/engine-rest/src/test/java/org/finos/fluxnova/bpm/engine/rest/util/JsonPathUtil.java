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
package org.finos.fluxnova.bpm.engine.rest.util;

import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.json.mapper.factory.Jackson3ObjectMapperFactory;
import io.restassured.path.json.JsonPath;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;

import java.text.SimpleDateFormat;

public final class JsonPathUtil {

  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXX";
  public static String dateFormatString = DEFAULT_DATE_FORMAT;

  public static JsonPath from(String json) {

      final Jackson3ObjectMapperFactory factory = (cls, charset) -> {
          SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
          return JsonMapper.builder()
                  .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                  .disable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
                  .defaultDateFormat(dateFormat)
                  .build();
      };

      JsonPathConfig config = new JsonPathConfig() {
          @Override
          public Jackson3ObjectMapperFactory jackson3ObjectMapperFactory() {
              return factory;
          }
      };

      return JsonPath.from(json).using(config);
  }

}
