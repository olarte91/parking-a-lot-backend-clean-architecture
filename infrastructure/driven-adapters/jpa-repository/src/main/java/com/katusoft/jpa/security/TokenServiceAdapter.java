package com.katusoft.jpa.security;

import com.katusoft.model.authentication.gateways.TokenService;
import com.katusoft.model.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class TokenServiceAdapter implements TokenService {

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private int jwtExpiration;

  @Override
  public String generateToken(User user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("username", user.getUsername());
    claims.put("email", user.getEmail());

    return createToken(claims, user.getUsername());
  }

  private String createToken(Map<String, Object> claims, String subject){
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
        .signWith(getSigInKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Key getSigInKey() {
    byte[] keyBytes = secret.getBytes();
    return Keys.hmacShaKeyFor(keyBytes);
  }

  @Override
  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token){
    return Jwts.parserBuilder()
        .setSigningKey(getSigInKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  @Override
  public boolean isTokenValid(String token, String username) {
    final String extracedUsername = extractUsername(token);
    return (extracedUsername.equals(username)) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }
}
