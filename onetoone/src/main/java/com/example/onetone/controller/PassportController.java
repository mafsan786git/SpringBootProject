package com.example.onetone.controller;


import com.example.onetone.entity.Passport;
import com.example.onetone.service.PassportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PassportController {

    @Autowired
    PassportServices passportServ;

    @GetMapping("/passport")
    public List<Passport> getAllPassport(){
        List<Passport> pass = passportServ.getAllPassport();
        return  pass;
    }

    @PostMapping("/passport")
    public Passport addPassport(@RequestBody Passport pass){
        Passport p1 = passportServ.addPassport(pass);
        return p1;
    }
}
