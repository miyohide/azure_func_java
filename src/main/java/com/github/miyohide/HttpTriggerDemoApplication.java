package com.github.miyohide;

import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HttpTriggerDemoApplication {

   @Bean
   public Function<String, String> uppercase() {
       return payload -> {
           String output = payload.toUpperCase();
           return String.format("Input: %s", output);         
       };
   }

   public static void main(String[] args) {
       SpringApplication.run(HttpTriggerDemoApplication.class, args);
   }
}
