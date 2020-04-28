package com.gagan.microservice3frontendservice.service;

import com.gagan.microservice3frontendservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public List<Product> fetchAllProducts() {
        return Arrays.asList(restTemplate.getForEntity(productUrl + "/products", Product[].class).getBody());
    }

    @Override
    public List<Product> fetchByCategory(String category) {
        return Arrays.asList(restTemplate.getForEntity(productUrl + "/products/category/" + category, Product[].class).getBody());
    }

    @Override
    public Product updateStocks(Integer productId, Integer quantity) {
        return restTemplate.postForObject(productUrl + "/products/" + productId + "/" + quantity, "", Product.class );
    }
}
