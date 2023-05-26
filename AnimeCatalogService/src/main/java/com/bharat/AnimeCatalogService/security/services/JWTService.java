package com.bharat.AnimeCatalogService.security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {
    @Value("${secret.key}")
    private String SECRET;

    public String getUsernameFromJWT(String jwt) {
        return getClaim(jwt, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(Map.of(
                "password", userDetails.getPassword()
        ), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,//these are private claims -> extra details of user
            UserDetails userDetails
    ){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValidJWT(String jwt, UserDetails userDetails){
        final String jwtUsername = getUsernameFromJWT(jwt);
        return jwtUsername.equals(userDetails.getUsername());
    }

    private <T> T getClaim(String jwt, Function<Claims, T> claimResolver){
        final Claims claim = getAllClaims(jwt);
        return claimResolver.apply(claim);
    }

    private Claims getAllClaims(String jwt){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwt).getBody();
    }

    private Key getSigningKey() {
        byte[] key = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(key);
    }
}
