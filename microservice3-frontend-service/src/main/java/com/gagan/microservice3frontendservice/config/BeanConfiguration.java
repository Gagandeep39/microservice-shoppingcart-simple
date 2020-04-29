package com.gagan.microservice3frontendservice.config;

import java.util.Arrays;

import com.gagan.microservice3frontendservice.model.Cart;
import com.gagan.microservice3frontendservice.model.Product;

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

    @Bean
    public Product getProduct(){
        Product product = new Product();
        product.setCategory("Product Service is Down");
        product.setId(0);
        product.setName("Error in Communication");
        product.setStock(0);
        product.setPrice(0);
        return product;
    }

    @Bean
    public Cart getCart(){
        Cart cart = new Cart();
        cart.setCartId(0);
        cart.setProducts(Arrays.asList(getProduct()));;
        return cart;
    }
}
