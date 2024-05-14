package com.example.beforyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/create")
    public String create() {
        return "create";
    }

    @GetMapping(value = "/update")
    public String update() {
        return "update";
    }
}
