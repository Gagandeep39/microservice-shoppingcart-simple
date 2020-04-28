package com.gagan.microservice3frontendservice.controller;

import com.gagan.microservice3frontendservice.model.Cart;
import com.gagan.microservice3frontendservice.model.Product;
import com.gagan.microservice3frontendservice.service.CartService;
import com.gagan.microservice3frontendservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Gagandeep
 * @date 28-04-2020
 * @time 20:23
 */

@Controller
@RequestMapping("/ProductCtrl")
public class ProductCatalogController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    private List<Product> products;
    private Cart cart;

    @GetMapping("/products")
    public String showAllProduct(Model model){
        cart = cartService.createCart();
        products = productService.fetchAllProducts();
        model.addAttribute("products", products);
        return "/ProductCatalog";
    }

    @PostMapping("/products/{id}")
    public String addItemToCart(@PathVariable Integer id, Model model){
        Product product = products.stream().filter(p->p.getId()==id).findFirst().get();
        cart = cartService.addItemToCart(cart.getCartId(), product);
        model.addAttribute("products", products);
        return "/ProductCatalog";
    }

    @GetMapping("/checkout")
    public String redirectToCart(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("cart", cart);
        return "redirect:/CartCtrl/carts";
    }
}
