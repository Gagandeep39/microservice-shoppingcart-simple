package com.gagan.microservice3frontendservice.service;

import java.util.Arrays;

import com.gagan.microservice3frontendservice.model.Cart;
import com.gagan.microservice3frontendservice.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 21:04
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @Autowired
    private Cart dummyCart;

    @Value("${service.url.cart}")
    private String cartUrl;

    Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    @HystrixCommand(fallbackMethod = "fallbackCreateCart")
    public Cart createCart() {
        return restTemplate.postForObject(cartUrl + "/carts", "", Cart.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackAddItemToCart")
    public Cart addItemToCart(Integer cartId, Product product) {
        return restTemplate.postForObject(cartUrl + "/carts/" + cartId, product, Cart.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackRemoveItemFromCart")
    public Cart removeItemFromCart(Integer cartId, Integer productId) {
        return restTemplate.postForObject(cartUrl + "/carts/" + cartId + "/" + productId, "", Cart.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackCheckout")
    public Cart checkout(Cart cart) {
        return restTemplate.postForObject(cartUrl + "carts/checkout/" + cart.getCartId(), "", Cart.class);
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackFetchById")
    public Cart fetchById(Integer cartId) {
        return restTemplate.getForObject(cartUrl + "/carts/" + cartId, Cart.class);
    }

    /**
     * Circuit Breaker Methods
     */
    public Cart fallbackCreateCart() {
        return dummyCart;
    }

    public Cart fallbackAddItemToCart(Integer cartId, Product product) {
        return dummyCart;
    }

    public Cart fallbackRemoveItemFromCart(Integer cartId, Integer productId) {
        return dummyCart;
    }

    public Cart fallbackCheckout(Cart cart) {
        return dummyCart;
    }

    public Cart fallbackFetchById(Integer cartId) {
        return dummyCart;
    }



}
