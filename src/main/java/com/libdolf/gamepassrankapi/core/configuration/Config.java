package com.libdolf.gamepassrankapi.core.configuration;

import com.google.gson.Gson;
import com.libdolf.gamepassrankapi.core.infra.GamePassApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public Gson gson(){
        return new Gson();
    }
}
