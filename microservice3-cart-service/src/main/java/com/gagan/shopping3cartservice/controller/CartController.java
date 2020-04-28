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

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/carts")
    public Cart createCart(){
        return cartService.createCart();
    }

    @PostMapping("/carts/{cartId}")
    public Cart addItemToCart(@PathVariable Integer cartId, @RequestBody Product product){
        return cartService.addItemToCart(cartId, product);
    }

    @PostMapping("/carts/{cartId}/{productId}")
    public Cart removeItemFromCart(@PathVariable Integer cartId, @PathVariable Integer productId){
        return cartService.removeItemFromCart(cartId, productId);
    }

    @GetMapping("/carts/{cartId}")
    public Cart fetchById(@PathVariable Integer cartId){
        return cartService.fetchById(cartId);
    }

}