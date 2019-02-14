package com.tomek.controller;

import com.tomek.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @PostMapping("/add")
    // take parameters from request and put Model type object as method parameter
    public String add(@RequestParam String title, @RequestParam String content, @RequestParam String tags, Model model) {
        if (!title.isEmpty() || !content.isEmpty()) {
            // create object based on parameters from request
            Article article = new Article(title, content, tags);
            // add object to Model
            model.addAttribute(article);
            // show succes.jsp
            // in success JSP use JSTL to get parameters from Article object added to model
            return "success";
        } else {
            return "redirect:error";
        }
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
