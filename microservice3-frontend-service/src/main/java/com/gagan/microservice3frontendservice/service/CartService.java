package com.gagan.microservice3frontendservice.service;

import com.gagan.microservice3frontendservice.model.Cart;
import com.gagan.microservice3frontendservice.model.Product;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 21:01
 */
public interface CartService {

    Cart createCart();
    Cart addItemToCart(Integer cartId, Product product);
    Cart removeItemFromCart(Integer cartId, Integer productId);
    Cart checkout(Cart cart);
    Cart fetchById(Integer cartId);

}
