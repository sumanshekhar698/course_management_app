package com.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomSingInController {

    @GetMapping("/signin")
    public String signIn(){
        return "login.html";
    }
}
