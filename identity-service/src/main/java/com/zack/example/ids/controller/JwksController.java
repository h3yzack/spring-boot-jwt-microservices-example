package com.zack.example.ids.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.JWKSet;
import com.zack.example.ids.security.KeyManager;

@RestController
public class JwksController {

    private final KeyManager keyManager;

    public JwksController(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    @GetMapping("/.well-known/jwks.json")
    public Map<String, Object> jwks() {
        return new JWKSet(keyManager.getJwk()).toJSONObject();
    }
}
