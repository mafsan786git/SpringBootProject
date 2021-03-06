package com.example.onetone.controller;

import com.example.onetone.entity.Passport;
import com.example.onetone.entity.Person;
import com.example.onetone.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonServices personServ;

    @GetMapping("/person")
    public List<Person> getAllPerson(){
        List<Person> person = personServ.getAllPerson();
        return person;
    }

    @PostMapping("/personadd")
    public Person addPerson(@RequestBody Person person){
        Person p1 = personServ.addPerson(person);
        return p1;
    }

    @PutMapping("/person/{id}/passport")
    public Person allocatePassport(@PathVariable("id") String personId,@RequestBody Passport passport){
        Person p1 = personServ.allocatePassport(personId,passport);
        return p1;
    }
}
