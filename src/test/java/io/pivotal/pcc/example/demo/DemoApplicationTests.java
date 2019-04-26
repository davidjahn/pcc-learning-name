package io.pivotal.pcc.example.demo;

import io.pivotal.pcc.example.demo.domain.HelloWorldModel;
import io.pivotal.pcc.example.demo.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldService.class)
public class DemoApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Mock
  private HelloWorldService service;

  @Test
  public void contextLoads() {

  }

  @Test
  public void sayHello(){
//    HelloWorldModel helloWorldModel = new HelloWorldModel();
//    Mockito.when(service.sayHelloWorld(helloWorldModel)).thenReturn("Hello World");
//    try {
//      mvc.perform(get("/hello")
//      .accept(MediaType.ALL)).
//          andExpect(status().isOk()).
//          andExpect(content().string("Hello"));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
  }

}
