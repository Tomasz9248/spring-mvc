package com.tomek.controller;

import com.tomek.component.EventHolder;
import com.tomek.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {

    private EventHolder eventHolder;

    // object is singleton by default. Refreshing page or even changing browser will not force creating new Event Holder instance
    @Autowired
    public EventController(EventHolder eventHolder) {
        this.eventHolder = eventHolder;
    }

    @PostMapping("/register")
    public String register (@RequestParam String firstName, @RequestParam String lastName) {
        Participant participant = new Participant(firstName, lastName);
        if (eventHolder.checkRegistration(participant))
            //redirect: and forward: redirect user to another url
            //redirect sends 2nd GET request to redirected address / forward works in a scope of 1 request but doesnt change url in user browser
            // instead of returning redirect user to wwww.host.com/error
            return "redirect:error";
    else {
        eventHolder.addParticipant(participant);
        return "redirect:success";
        }
    }

    @GetMapping("/success")
    public String addProduct() {
        return "success";
    }
    // now /error servlet returns assigned view to the user
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/show")
    public String show() {
        for(Participant p: eventHolder.getParticipants()) {
            System.out.println(p);
        }
        return "redirect:/";
    }
}