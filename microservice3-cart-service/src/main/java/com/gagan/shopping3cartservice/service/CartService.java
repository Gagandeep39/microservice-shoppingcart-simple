/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-28 19:13:09
 * @modify date 2020-04-28 19:13:09
 * @desc [description]
 */
package com.gagan.shopping3cartservice.service;

import com.gagan.shopping3cartservice.model.Cart;
import com.gagan.shopping3cartservice.model.Product;

public interface CartService {

    public Cart fetchById(Integer cartId);
    public Cart addItemToCart(Integer cartId, Product product);
    public Cart removeItemFromCart(Integer cartId, Integer prodcutId);
    public Cart createCart();
    public Cart checkOut(Integer cartId);

}