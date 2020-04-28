package com.gagan.microservice3frontendservice.controller;

import com.gagan.microservice3frontendservice.model.Cart;
import com.gagan.microservice3frontendservice.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 20:58
 */
@Controller
@RequestMapping("/CartCtrl")
public class CartController {

    @Autowired
    private CartService cartService;

    private Cart cart;

    Logger logger = LoggerFactory.getLogger(CartController.class);

    @GetMapping("/carts")
    public String showCart(Model model){
        cart = (Cart) model.getAttribute("cart");
        logger.info(cart.toString());
        int total = calculateTotal(cart);
        model.addAttribute("total", total);
        model.addAttribute("cart", cart);
        return "/ShoppingCart";
    }

    private int calculateTotal(Cart cart) {
        int amount = 0;
        for (int i = 0; i < cart.getProducts().size(); i++)
            amount += cart.getProducts().get(i).getPrice();
        return amount;
    }

    @PostMapping("/carts/{id}")
    public String removeItemFromCart(Model model, @PathVariable Integer id){
        cart = cartService.removeItemFromCart(cart.getCartId(), id);
        int total = calculateTotal(cart);
        model.addAttribute("total", total);
        model.addAttribute("cart", cart);
        return "/ShoppingCart";
    }

    @GetMapping("/checkout")
    public String checkOut(){
        cart = cartService.checkout(cart);
        return "redirect:/ProductCtrl/products";
    }

}
