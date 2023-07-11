package com.wix.kickstart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public ResponseEntity<String> rootResponse() {
        String welcomeMessage = "Welcome to the spring boot integration test sample api";
        return new ResponseEntity<>(welcomeMessage, HttpStatus.OK);
    }

}
