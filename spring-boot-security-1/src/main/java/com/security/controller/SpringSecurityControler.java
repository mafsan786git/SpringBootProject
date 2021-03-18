package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityControler {

    @GetMapping("/")
    public String welcome(){
        return "WELCOME";
    }
}
