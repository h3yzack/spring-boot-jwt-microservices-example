
package com.zack.example.ids.service;

import com.zack.example.common.dto.LoginResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("dev")
@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    AuthenticationService authenticationService;

    @Test
    void testLoginSuccess() throws Exception {
        LoginResponse response = authenticationService.login("admin", "password");
        assertNotNull(response);
        assertNotNull(response.token());
    }

    @Test
    void testLoginFailure() {
        Exception exception = assertThrows(Exception.class, () -> {
            authenticationService.login("admin", "wrongpassword");
        });
        assertNotNull(exception.getMessage());
        assertEquals("Invalid credentials", exception.getMessage());
    }

}
