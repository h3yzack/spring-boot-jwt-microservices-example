package com.zack.example.ids.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KeyManagerTest {
    private KeyManager keyManager;

    @BeforeEach
    void setUp() throws Exception {
        keyManager = new KeyManager();
        keyManager.init();
    }

    @Test
    void testKeyInitialization() throws Exception {
        
        assertNotNull(keyManager.getPrivateKey(), "Private key should not be null");
        assertNotNull(keyManager.getJwk(), "JWK should not be null");
        assertNotNull(keyManager.getKeyId(), "Key ID should not be null");
    }
}
