/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 18:46:18
 * @modify date 2020-04-28 18:46:18
 * @desc [description]
 */
package com.gagan.microservice3productservice.service;

import java.util.List;

import com.gagan.microservice3productservice.model.Product;

public interface ProductService {

    public List<Product> fetchAllProduct();
    public List<Product> fetchByCategory(String category);
    public Product fetchById(Integer id);
    public Product updateStock(Integer productId, Integer quantity);
}