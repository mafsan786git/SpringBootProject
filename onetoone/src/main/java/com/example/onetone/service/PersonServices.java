package com.example.onetone.service;

import com.example.onetone.entity.Passport;
import com.example.onetone.entity.Person;
import com.example.onetone.repository.PassportRepository;
import com.example.onetone.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepo;

    @Autowired
    PassportRepository passportRepo;
    public List<Person> getAllPerson() {
        List<Person> person = personRepo.findAll();
        return  person;
    }
    
    public Person addPerson(Person person) {
        Person person1 = personRepo.save(person);
        return person1;
    }

    public Person allocatePassport(String personId, Passport passport) {
        Optional<Passport> pass1 = passportRepo.findById(passport.getPassId());
        Person person = personRepo.findById(personId).get();
        if(pass1.isEmpty())
        {
            passportRepo.save(passport);
        }
        person.setPassport(passport);
        personRepo.save(person);
        return person;
    }

    public void getPassportOfPerson(String s) {
        //first find the object of person
        Optional<Person> per = personRepo.findById(s);
        if(per.isEmpty())
            System.out.println("person is empty at 456");
        else {
            //print passport id of person
            System.out.println(per.get().getPassport().getPassId());
            System.out.println(per.get().getPassport().getPassNum());
        }

    }
}
