package com.gagan.shopping3cartservice.service;

import com.gagan.shopping3cartservice.model.Cart;
import com.gagan.shopping3cartservice.model.Product;
import com.gagan.shopping3cartservice.repository.CartRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CircuitBreakerService circuiteBreakerService;

    @Autowired
    private Cart dummyCart;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.service.product}")
    private String productUrl;

    Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    public Cart fetchById(Integer cartId) {
        return cartRepository.findById(cartId).get();
    }

    @Override
    public Cart addItemToCart(Integer cartId, Product product) {
        Cart cart = fetchById(cartId);
        cart.addProduct(product);
        Cart newCart = cartRepository.save(cart);
        return newCart;
    }

    @Override
    public Cart removeItemFromCart(Integer cartId, Integer productId) {
        Cart cart = fetchById(cartId);
        cart.removeProduct(productId);
        Cart updatedCart = cartRepository.save(cart);
        return updatedCart;
    }

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        Cart newCart = cartRepository.save(cart);
        return newCart;
    }

    @Override
    // @HystrixCommand(fallbackMethod = "fallbackCheckOut")
    public Cart checkOut(Integer cartId) {
        Cart cart = fetchById(cartId);
        for (Product p : cart.getProducts()) {
            Product newProduct = circuiteBreakerService.updateStock(p);
            if(newProduct.getId()==0)
                return dummyCart;
        }
        return cart;
    }

    public Cart fallbackCheckOut(Integer cartId) {
        return dummyCart;
    }

}