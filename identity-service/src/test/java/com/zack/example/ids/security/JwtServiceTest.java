package com.zack.example.ids.security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtServiceTest {

    @Autowired
    JwtService jwtService;

    @Autowired
    KeyManager keyManager;

    @Test
    void testGenerateToken() throws Exception {

        String token = jwtService.generateToken("testuser");

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}
