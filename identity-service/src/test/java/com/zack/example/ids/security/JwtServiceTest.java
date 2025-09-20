package com.zack.example.ids.security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.zack.example.ids.entity.UserRole;

@ActiveProfiles("dev")
@SpringBootTest
public class JwtServiceTest {

    @Autowired
    JwtService jwtService;

    @Autowired
    KeyManager keyManager;

    @Test
    void testGenerateToken() throws Exception {

        UserRole adminRole = new UserRole();
        adminRole.setName("ADMIN");

        String token = jwtService.generateToken("admin", Set.of(adminRole));

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}
