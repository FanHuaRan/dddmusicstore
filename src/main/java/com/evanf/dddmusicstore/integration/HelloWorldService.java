/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.evanf.dddmusicstore.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Optional;

import io.swagger.models.Swagger;
import springfox.documentation.service.Documentation;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

@Component
public class HelloWorldService {
	@Autowired
	private DocumentationCache documentationCache;

	@Autowired
	private ServiceModelToSwagger2Mapper mapper;

	@Autowired
	private ServiceProperties configuration;

	public String getHelloMessage(String name) {
		String groupName = Optional.fromNullable("").or(Docket.DEFAULT_GROUP_NAME);
		Documentation documentation = documentationCache.documentationByGroup(groupName);
		Swagger swagger = mapper.mapDocumentation(documentation);

		return this.configuration.getGreeting() + " " + name;
	}

}
