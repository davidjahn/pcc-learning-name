package io.pivotal.pcc.example.demo;

import io.pivotal.pcc.example.demo.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


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
//    Mockito.when(service.sayHelloWorld("Hello World")).thenReturn("Hello World");
//    try {
//      mvc.perform(MockMvcRequestBuilders.get("/hello")
//      .accept(MediaType.ALL)).
//          andExpect(MockMvcResultMatchers.status().isOk()).
//          andExpect(MockMvcResultMatchers.content().string(ArgumentMatchers.contains("Hello World")));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
  }

}
