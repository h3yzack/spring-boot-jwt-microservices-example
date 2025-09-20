package com.zack.example.ids.security;

import java.security.interfaces.RSAPrivateKey;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.zack.example.ids.entity.UserRole;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;

@Service
public class JwtService {
    private final KeyManager keyManager;
    private final long expirationMs = 1000 * 60 * 15; // 15 minutes

    public JwtService(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public String generateToken(String username, Set<UserRole> roles) throws JOSEException {
        RSAPrivateKey privateKey = keyManager.getPrivateKey();
        return Jwts.builder()
                .subject(username)
                .claim("roles", roles.stream().map(UserRole::getName).collect(Collectors.toList()))  // Other service can utilize this for role-based auth
                .expiration(new Date(System.currentTimeMillis() + expirationMs))
                .issuedAt(new Date())
                .header().add("kid", keyManager.getKeyId()).and()
                .signWith(privateKey, SIG.RS256)
                .compact();
    }
}
