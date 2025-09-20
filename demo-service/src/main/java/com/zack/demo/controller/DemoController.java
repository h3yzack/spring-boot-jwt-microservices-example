package com.zack.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @GetMapping("/whoami")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public UserDto whoami() {
        return identityClient.getUser(); // Feign call
    }

    @GetMapping("/admin/stats")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminStats() {
        return "Admin stats only for ROLE_ADMIN";
    }
}
