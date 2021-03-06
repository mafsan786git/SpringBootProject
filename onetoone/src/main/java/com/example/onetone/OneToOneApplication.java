package com.example.onetone;

import com.example.onetone.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Autowired
	PersonServices personServ;
	@Override
	public void run(String... args) throws Exception {
		personServ.getPassportOfPerson("456");
	}
}
