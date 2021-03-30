package com.darktangle.cardatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.darktangle.cardatabase.domain.Car;
import com.darktangle.cardatabase.domain.CarRepository;
import com.darktangle.cardatabase.domain.Owner;
import com.darktangle.cardatabase.domain.OwnerRepository;
import com.darktangle.cardatabase.domain.User;
import com.darktangle.cardatabase.domain.UserRepository;

@SpringBootApplication
public class CardatabaseApplication {
	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			orepository.save(owner1);
			orepository.save(owner2);

			repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));

			urepository.save(new User("user", "$2a$04$ohRrvTVGUVNZwNn8ZiSwV.5qUbT7GwO1zkAz5CUl2YebNxGAUB.Ne", "USER"));
			urepository.save(new User("admin", "$2a$04$Dro6jgQb9iyRiwRwlQSdJuywXSe9uZMdZWkUarRg9BUM0W1W38gUu", "ADMIN"));
		};
	}
}
