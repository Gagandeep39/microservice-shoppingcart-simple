package com.gagan.microservice3frontendservice.service;

import com.gagan.microservice3frontendservice.model.Product;

import java.util.List;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 20:34
 */
public interface ProductService {

    List<Product> fetchAllProducts();
    List<Product> fetchByCategory(String category);
    Product updateStocks(Integer productId, Integer quantity);

}
