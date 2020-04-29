/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 19:44:44
 * @modify date 2020-04-28 19:44:44
 * @desc [description]
 */
package com.gagan.shopping3cartservice.controller;

import com.gagan.shopping3cartservice.model.Cart;
import com.gagan.shopping3cartservice.model.Product;
import com.gagan.shopping3cartservice.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("Manage cart related operation")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/carts")
    @ApiOperation(value = "Ceates a new cart")
    public Cart createCart(){
        return cartService.createCart();
    }

    @PostMapping("/carts/{cartId}")
    @ApiOperation(value = "Addes an item to cart based on ID")
    public Cart addItemToCart(
        @ApiParam(value = "Cart ID - ID of cart in which item will be addd")
        @PathVariable Integer cartId, 
        @ApiParam(value = "Product - TO be added in cart")
        @RequestBody Product product){
        return cartService.addItemToCart(cartId, product);
    }

    @PostMapping("/carts/{cartId}/{productId}")
    @ApiOperation(value = "Remove an item using cart id and product id")
    public Cart removeItemFromCart(
        @ApiParam(value = "ID - ID of cart from which item will be rremoved")
        @PathVariable Integer cartId,
        @ApiParam(value = "ID - ID of product to be remoed")
        @PathVariable Integer productId){
        return cartService.removeItemFromCart(cartId, productId);
    }

    @GetMapping("/carts/{cartId}")
    @ApiOperation(value = "Fetch a cart by id")
    public Cart fetchById(
        @ApiParam(value = "ID through which cart will be fetched ")
        @PathVariable Integer cartId){
        return cartService.fetchById(cartId);
    }

    @PostMapping("/carts/checkout/{cartId}")
    @ApiOperation(value = "Checkout - Deduct procdutct stocks from product repository")
    public Cart checkout(@PathVariable Integer cartId){
        return cartService.checkOut(cartId);
    }

}