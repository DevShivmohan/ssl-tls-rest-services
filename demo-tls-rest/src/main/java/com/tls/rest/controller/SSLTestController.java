package com.tls.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssl-tls")
public class SSLTestController {

    @GetMapping
    public ResponseEntity<?> getTestMessage(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Welcome to SSL-TLS configuration");
    }
}
