package io.pivotal.pcc.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

  @Cacheable("HelloWorld")
  public String sayHelloWorld(String helloString){
    return "Hello" + helloString + System.nanoTime();
  }
}
