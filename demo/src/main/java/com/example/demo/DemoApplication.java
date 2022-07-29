package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController//restful endpoint server such as @GETmapping or postmapping
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@GetMapping//this is to return to restful endpoint. for this we need @restcontroller
//	public String hello(){
//		return "Hello world";
//	}




}
