package com.gagan.microservice3frontendservice.service;

import com.gagan.microservice3frontendservice.model.Cart;
import com.gagan.microservice3frontendservice.model.Product;
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

    @Value("${service.url.cart}")
    private String cartUrl;

    Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);


    @Override
    public Cart createCart() {
        return restTemplate.postForObject(cartUrl + "/carts", "", Cart.class);
    }

    @Override
    public Cart addItemToCart(Integer cartId, Product product) {
        return restTemplate.postForObject(cartUrl + "/carts/" + cartId, product, Cart.class);
    }

    @Override
    public Cart removeItemFromCart(Integer cartId, Integer productId) {
        return restTemplate.postForObject(cartUrl + "/carts/" + cartId + "/" + productId, "", Cart.class);
    }

    @Override
    public Cart checkout(Cart cart) {
        for(Product product: cart.getProducts()){
            productService.updateStocks(product.getId(), 1);
        }
        return fetchById(cart.getCartId());
    }

    @Override
    public Cart fetchById(Integer cartId) {
        return restTemplate.getForObject(cartUrl + "/carts/" + cartId, Cart.class);
    }
}
