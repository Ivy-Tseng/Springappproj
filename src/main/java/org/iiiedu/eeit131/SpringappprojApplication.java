package org.iiiedu.eeit131;

import org.iiiedu.eeit131.model.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringappprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappprojApplication.class, args);
	}
	
	@Bean
	public Cat cat() {
		Cat c = new Cat("凱蒂貓", 11.0);
		return c;
	}
}
