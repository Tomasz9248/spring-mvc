package com.tomek.controller;

import com.tomek.component.TimeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeController {

    TimeComponent timeComponent;

    // every time application gets request new instance of TimeComponent is injected
    @Autowired
    public TimeController(TimeComponent timeComponent) {
        this.timeComponent = timeComponent;
    }

    @GetMapping("/time")
    public String printTime(){
        // print "current time" in console. current time = time of timeComponent creation
        // if scope is singleton output will be same for every refresh / if is scope then every refresh gives different value
        System.out.println(timeComponent.getTime());
        return "index";
    }
}
