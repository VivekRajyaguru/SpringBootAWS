package com;



import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.Repository.UserRepository;
import com.beans.User;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner (UserRepository userRepo) {
	
		return args -> {
			/*
			 * Using Stream
			 * */
			Stream.of("Vivek","User","Admin","Test").forEach(e -> userRepo.save(new User(e)));
			
			
			/*
			 * Using Arrays Class
			 * 
			 * Arrays.asList("Vivek,User,Admin,Test".split(","))
			.forEach( e -> userRepo.save(new User(e)));
			
			*/			
			
			userRepo.findAll().forEach(System.out::println);
		};
		
		
	}
}

