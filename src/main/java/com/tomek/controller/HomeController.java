package com.tomek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home"; // prefix and suffix are defined in properties. In fact we return /WEB-INF/views/home.jsp
    }
}