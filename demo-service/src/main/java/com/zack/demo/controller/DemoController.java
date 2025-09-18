package com.zack.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zack.demo.client.IdentityClient;
import com.zack.example.common.dto.UserDto;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final IdentityClient identityClient;

    public DemoController(IdentityClient identityClient) {
        this.identityClient = identityClient;
    }

    @GetMapping("/info")
    public String greet() {
        return "Hello there from Demo Service!";
    }

    // Secured endpoint demonstrating Feign inter-service communication
    @GetMapping("/items")
    public List<String> getItems(Principal principal) {
        String username = principal.getName();
        UserDto user = identityClient.getUser(username); // Feign call
        return List.of(
                "Owner: " + user.fullName(),
                "email: " + user.email(),
                "username: " + user.username()
        );
    }
}
