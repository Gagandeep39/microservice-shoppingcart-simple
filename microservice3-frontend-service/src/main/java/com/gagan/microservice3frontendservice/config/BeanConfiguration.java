package com.gagan.microservice3frontendservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 20:23
 */

@Configuration
public class BeanConfiguration {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ModelAndView getModelAndView(){
        return new ModelAndView();
    }
}
