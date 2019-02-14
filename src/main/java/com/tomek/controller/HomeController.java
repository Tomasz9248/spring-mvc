package com.tomek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/") // handle GET request for url "/" and send response index.jsp
    public String home() {
        return "index";
    }

    @PostMapping("/") // handle POST type request
    // if name of request param and method param are the same name = is not necessary
    public String calculate(@RequestParam(name = "valueA", defaultValue = "0") int valueA, // get param ValueA from request and set it to int valueA in method, default value set to 0
                            // if name of request param and method param are the same 'name =' is not necessary
                            @RequestParam(defaultValue = "0") int valueB) { // get param ValueB from request and set it to int valueB in method, default value set to 0
        int result = valueA + valueB;
        System.out.printf("%d + %d = %d\n", valueA, valueB, result);
        return "index";
    }
}