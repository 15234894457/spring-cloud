package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class DemoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigServerApplication.class, args);
	}
	
	
	
	
}