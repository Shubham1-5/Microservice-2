package com.shubham.Microservice2Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GET 127.0.0.1:7072/ms2/v1/messages
 */
@SpringBootApplication
@RestController
@RequestMapping("/messages")
@EnableDiscoveryClient
public class Microservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}

	@GetMapping
	public ResponseEntity helloMessage(){
		return new ResponseEntity("Hello from the Microservice 2", HttpStatus.OK);
	}
}
