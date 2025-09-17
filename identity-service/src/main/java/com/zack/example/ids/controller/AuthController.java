package com.zack.example.ids.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.JOSEException;
import com.zack.example.common.dto.LoginRequest;
import com.zack.example.common.dto.LoginResponse;
import com.zack.example.common.dto.UserDto;
import com.zack.example.ids.security.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) throws JOSEException {
        if ("admin".equals(req.username()) && "password".equals(req.password())) {
            String token = jwtService.generateToken(req.username());
            return ResponseEntity.ok(new LoginResponse(token));
        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/users/{username}")
    public UserDto getUser(@PathVariable String username) {
        return new UserDto(username, "Admin User", "admin@example.com");
    }
    
}
