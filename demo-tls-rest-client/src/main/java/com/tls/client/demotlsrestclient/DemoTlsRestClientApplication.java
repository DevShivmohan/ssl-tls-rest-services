package com.tls.client.demotlsrestclient;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoTlsRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTlsRestClientApplication.class, args);
	}

	@PostConstruct
	public void init1(){
		RestTemplate restTemplate=new RestTemplate();
		final var response= restTemplate.getForEntity("https://localhost:8443/ssl-tls",String.class);
		System.out.println("Response from SSL-TLS server "+response);
	}
}
