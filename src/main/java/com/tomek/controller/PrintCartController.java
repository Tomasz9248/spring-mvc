package com.tomek.controller;

import com.tomek.component.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrintCartController {

    private ShoppingCart cart;

    @Autowired
    public PrintCartController(ShoppingCart cart) {
        this.cart = cart;
    }
    // in real life situation there will be 1 controller only
    // scope is session so even after refreshing page cart stores previously added products
    @GetMapping("/print")
    public String printProducts() {
        for (String product : cart.getProducts()) {
            System.out.println(product);
        }
        return "index";
    }
}
