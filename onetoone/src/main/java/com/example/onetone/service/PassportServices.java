package com.example.onetone.service;


import com.example.onetone.entity.Passport;
import com.example.onetone.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServices {
    @Autowired
    PassportRepository passRepo;
    public List<Passport> getAllPassport() {
        List<Passport> p1 = passRepo.findAll();
        return p1;
    }

    public Passport addPassport(Passport pass) {
        Passport p1 = passRepo.save(pass);
        return p1;
    }
}
