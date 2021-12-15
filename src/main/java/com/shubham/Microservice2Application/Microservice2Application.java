package com.shubham.Microservice2Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
@EnableDiscoveryClient
public class Microservice2Application {

	@Value("hello moto")
	private String welcomeMessage1;

	@Value("{welcome.message: default value}")
	private String welcomeMessage2;

	@Autowired
	private ServerProperties serverProperties;

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}

	@GetMapping()
	public ResponseEntity helloMessage(){
		/**
		 * Some identifier for the running instance
		 *
		 * The running portNumber
		 */
		System.out.println("The port number hit is :" + serverProperties.getPort());
		return new ResponseEntity("Hello from the Microservice 2 " + welcomeMessage1 + welcomeMessage2, HttpStatus.OK);
	}
}
