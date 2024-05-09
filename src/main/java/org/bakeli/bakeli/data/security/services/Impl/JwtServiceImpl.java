package org.bakeli.bakeli.data.security.services.Impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl {
    //clee prive 64 caracteres
    private static final String SECRET = "N5v52H7YWUzsFgXyrA3SdcJtL6B9g2DqRyv5w7f3xEXqAZKhT8JL4Ce3kFnGyjK";



    public String createToken(String nom) {
        return Jwts.builder()
                .setClaims(new HashMap<String,Object>() )
                .setSubject(nom)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) //24h
                .signWith(getKey(), SignatureAlgorithm.HS256)

                .compact();
    }

    private Key getKey() {
        //byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET)); //crypte la clé
    }

    //extraire le nom


    public  String extractName(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    private Claims extractAllClaim(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public Date extractExpiration(String token) {
        return extractAllClaim(token).getExpiration();
    }

    public Boolean isTokenExpired(String token) {
        try {
            return extractExpiration(token).before(new Date());
        }
        catch (ExpiredJwtException e) {
            return true;
        }
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


}
