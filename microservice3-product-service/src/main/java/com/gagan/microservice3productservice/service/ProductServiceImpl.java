/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 18:46:20
 * @modify date 2020-04-28 18:46:20
 * @desc [description]
 */
package com.gagan.microservice3productservice.service;

import java.util.List;

import com.gagan.microservice3productservice.model.Product;
import com.gagan.microservice3productservice.respository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> fetchAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> fetchByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product fetchById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateStock(Integer productId, Integer quantity) {
        Product p = fetchById(productId);
        p.setStock(p.getStock()-quantity);
        Product newProduct = productRepository.save(p);
        return newProduct;
    }

}