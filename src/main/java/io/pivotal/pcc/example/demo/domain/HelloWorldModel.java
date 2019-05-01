package io.pivotal.pcc.example.demo.domain;

import org.springframework.data.gemfire.mapping.annotation.Region;

@Region
public class HelloWorldModel {


  @Override
  public String toString() {
    return "Hello World";
  }
}
