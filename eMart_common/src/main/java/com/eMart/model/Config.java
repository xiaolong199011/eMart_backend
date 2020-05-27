package com.eMart.model;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class Config {

@Bean
public RestTemplate restTemplate(RestTemplateBuilder builder) {
   // Do any additional configuration here
   return builder.build();
}


}
