package io.pivotal.pcc.example.demo.domain;

import org.springframework.data.gemfire.mapping.annotation.Region;

@Region
public class HelloWorldModel {

  private String world = "world";

  @Override
  public String toString() {
    return "HelloWorldModel{" +
        "world='" + world + '\'' +
        '}';
  }
}
