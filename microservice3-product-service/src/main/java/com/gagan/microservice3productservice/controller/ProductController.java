/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 18:46:11
 * @modify date 2020-04-28 18:46:11
 * @desc [description]
 */
package com.gagan.microservice3productservice.controller;

import java.util.List;

import com.gagan.microservice3productservice.model.Product;
import com.gagan.microservice3productservice.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> fetchAllProducts(){
        return productService.fetchAllProduct();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Integer id){
        return productService.fetchById(id);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> fetchByCategory(@PathVariable String category){
        return productService.fetchByCategory(category);
    }

    @PostMapping("products/{productId}/{quantity}")
    public Product updateStock(@PathVariable Integer productId,@PathVariable Integer quantity){
        return productService.updateStock(productId, quantity);
    }

}