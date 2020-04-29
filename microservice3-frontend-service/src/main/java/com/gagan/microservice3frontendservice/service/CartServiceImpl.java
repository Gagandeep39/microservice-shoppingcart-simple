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
    private Cart cart;

    @Value("${service.url.cart}")
    private String cartUrl;

    Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    @HystrixCommand(fallbackMethod = "fallbackCreateCart")
    public Cart createCart() {
        return restTemplate.postForObject(cartUrl + "/carts", "", Cart.class);
    }

    public Cart fallbackCreateCart() {
        return cart;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackAddItemToCart")
    public Cart addItemToCart(Integer cartId, Product product) {
        return restTemplate.postForObject(cartUrl + "/carts/" + cartId, product, Cart.class);
    }

    public Cart fallbackAddItemToCart(Integer cartId, Product product) {
        return cart;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackRemoveItemFromCart")
    public Cart removeItemFromCart(Integer cartId, Integer productId) {
        return restTemplate.postForObject(cartUrl + "/carts/" + cartId + "/" + productId, "", Cart.class);
    }

    public Cart fallbackRemoveItemFromCart(Integer cartId, Integer productId) {
        return cart;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackCheckout")
    public Cart checkout(Cart cart) {
        for (Product product : cart.getProducts()) {
            productService.updateStocks(product.getId(), 1);
        }
        return fetchById(cart.getCartId());
    }

    public Cart fallbackCheckout(Cart cart) {
        return cart;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallbackFetchById")
    public Cart fetchById(Integer cartId) {
        return restTemplate.getForObject(cartUrl + "/carts/" + cartId, Cart.class);
    }

    public Cart fallbackFetchById(Integer cartId) {
        return cart;
    }

}
