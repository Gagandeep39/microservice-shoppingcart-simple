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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("Product Cntroller to manage product crud operation")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @ApiOperation(value = "Fetch all products")
    public List<Product> fetchAllProducts(){
        return productService.fetchAllProduct();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Fetch By ID")
    public Product findById(
        @ApiParam(value = "ID through which product will be fetched")
        @PathVariable Integer id){
        return productService.fetchById(id);
    }

    @GetMapping("/products/category/{category}")
    @ApiOperation(value = "Fetch By Category")
    public List<Product> fetchByCategory(
        @ApiParam(value = "Category throgh which product wil be fetched ")
        @PathVariable String category){
        return productService.fetchByCategory(category);
    }

    @PostMapping("products/{productId}/{quantity}")
    @ApiOperation(value = "Update Quantity")
    public Product updateStock(
        @ApiParam(value = "Product ID whose stocks are to b updated")
        @PathVariable Integer productId,
        @ApiParam(value = "Quantity by which the stucks must be deducted")
        @PathVariable Integer quantity){
        return productService.updateStock(productId, quantity);
    }

}