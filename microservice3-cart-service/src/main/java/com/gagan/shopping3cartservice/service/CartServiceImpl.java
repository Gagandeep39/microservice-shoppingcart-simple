package com.gagan.shopping3cartservice.service;

import com.gagan.shopping3cartservice.model.Cart;
import com.gagan.shopping3cartservice.model.Product;
import com.gagan.shopping3cartservice.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

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


}