package com.tomek.controller;

import com.tomek.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
    model.addAttribute("helloMessage", "Hello, you!");
    model.addAttribute("formArticle",
            new Article());
    return "index";
    }
}
