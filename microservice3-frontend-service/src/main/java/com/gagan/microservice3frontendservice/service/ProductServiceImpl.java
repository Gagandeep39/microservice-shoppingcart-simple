package com.gagan.microservice3frontendservice.service;

import java.util.Arrays;
import java.util.List;

import com.gagan.microservice3frontendservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 20:36
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.url.product}")
    private String productUrl;

    @Autowired
    private Product dummyProduct;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackFetchAllProducts")
    public List<Product> fetchAllProducts() {
        return Arrays.asList(restTemplate.getForEntity(productUrl + "/products", Product[].class).getBody());
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackFetchByCategory")
    public List<Product> fetchByCategory(String category) {
        return Arrays.asList(restTemplate.getForEntity(productUrl + "/products/category/" + category, Product[].class).getBody());
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackUpdateStocks")
    public Product updateStocks(Integer productId, Integer quantity) {
        return restTemplate.postForObject(productUrl + "/products/" + productId + "/" + quantity, "", Product.class );
    }

    /**
     * 
     * Circui Breake Methods
     */

    public List<Product> fallbackFetchAllProducts() {
        return Arrays.asList(dummyProduct);
    }

    public List<Product> fallbackFetchByCategory(String category) {
        return Arrays.asList(dummyProduct);
    }

    public Product fallbackUpdateStocks(Integer productId, Integer quantity) {
        return dummyProduct;
    }

}
