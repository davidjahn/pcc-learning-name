package io.pivotal.pcc.example.demo.config;

import io.pivotal.pcc.example.demo.domain.HelloWorldModel;
import io.pivotal.pcc.example.demo.service.HelloWorldService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private static Logger logger = LogManager.getLogger(HelloWorldController.class);
  private HelloWorldModel helloWorldModel = new HelloWorldModel();

  @RequestMapping("/hello")
  public String sayHello(){
    logger.info("**Received request**");
    HelloWorldService helloWorldService = new HelloWorldService();

    return helloWorldService.sayHelloWorld(helloWorldModel.toString());
  }

  @RequestMapping("/")
  public String ping(){
    logger.info("**Received request**");

    return "<h1>Pong<h1>";
  }

}
