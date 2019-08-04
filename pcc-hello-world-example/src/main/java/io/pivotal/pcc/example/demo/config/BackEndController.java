/*
 * Copyright (C) 2019-Present Pivotal Software, Inc. All rights reserved.
 *
 * This program and the accompanying materials are made available under
 * the terms of the under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for
 * the specific language governing permissions and limitations under the License.
 */

package io.pivotal.pcc.example.demo.config;

import io.pivotal.pcc.example.demo.service.HelloWorldService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackEndController {

  private static Logger logger = LogManager.getLogger(BackEndController.class);

  private final HelloWorldService helloWorldService;

  @Autowired
  public BackEndController(
      HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  @CrossOrigin
  @RequestMapping("/v0/users")
  public String sayHello(){
    logger.info("**Received request**");
    return "{}";
  }

}
