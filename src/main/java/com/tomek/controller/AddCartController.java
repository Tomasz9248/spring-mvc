package com.tomek.controller;

import com.tomek.component.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddCartController {

    private ShoppingCart cart;

    @Autowired
    AddCartController(ShoppingCart cart) {
        this.cart = cart;
    }

    // due to session scope added products are still in cart even after refreshing page
    // cart object is created with 1st connection when session starts its not recreated after refresh
    @PostMapping("/add")
    public String addProduct(@RequestParam String product) {
        cart.addProduct(product);
        return "index";
    }
}
