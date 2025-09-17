package com.zack.example.ids.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;

import jakarta.annotation.PostConstruct;

@Component
public class KeyManager {

    private RSAKey jwk;

    @PostConstruct
    public void init() throws Exception {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair kp = gen.generateKeyPair();
        RSAPublicKey pub = (RSAPublicKey) kp.getPublic();
        RSAPrivateKey priv = (RSAPrivateKey) kp.getPrivate();

        this.jwk = new RSAKey.Builder(pub)
                .privateKey(priv)
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    public RSAKey getJwk() {
        return jwk.toPublicJWK();
    }

    public RSAPrivateKey getPrivateKey() throws JOSEException {
        return (RSAPrivateKey) jwk.toRSAPrivateKey();
    }

    public String getKeyId() {
        return jwk.getKeyID();
    }
}
