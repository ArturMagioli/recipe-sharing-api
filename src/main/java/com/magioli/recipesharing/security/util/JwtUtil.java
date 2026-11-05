package com.magioli.recipesharing.security.util;

import com.magioli.recipesharing.constants.ApplicationConstants;
import com.magioli.recipesharing.entities.RecipeSharingUser;
import com.magioli.recipesharing.user.dto.RecipeSharingUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final Environment env;

    public String generateToken(Authentication authentication) {
        String secret = env.getProperty("jwt.secret", ApplicationConstants.DEFAULT_JWT_SECRET);
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        RecipeSharingUser principal = (RecipeSharingUser) authentication.getPrincipal();

        return Jwts.builder().issuer("Recipe Sharing API").subject("JWT Token")
                .claim("username", principal.getUsername())
                .claim("email", principal.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() * 24 * 60 * 60 * 1000))
                .signWith(secretKey)
                .compact();
    }

    public Authentication validateToken(String token) throws JwtException {
        String secret = env.getProperty("jwt.secret", ApplicationConstants.DEFAULT_JWT_SECRET);

        if (secret.isEmpty()) {
            throw new JwtException("There is no provided secret");
        }
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
        String username = String.valueOf(claims.get("username"));
        String email = String.valueOf(claims.get("email"));

        Authentication auth = UsernamePasswordAuthenticationToken.
                authenticated(new RecipeSharingUserDto(username, email, Collections.emptyList()), null, Collections.emptyList());

        return auth;
    }
}
