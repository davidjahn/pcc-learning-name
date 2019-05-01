package io.pivotal.pcc.example.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

  private static Logger logger = LogManager.getLogger(HelloWorldService.class);

  @Cacheable("HelloWorld")
  public String sayHelloWorld(String helloString){
    logger.info("************Hitting the service");
    return "Hello" + helloString + System.nanoTime();
  }
}
