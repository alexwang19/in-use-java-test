package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String main(Model model) {
        return "Hello, World!";
    }
}
