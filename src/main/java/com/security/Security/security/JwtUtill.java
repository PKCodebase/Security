//package com.security.Security.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Base64;
//import java.util.Date;
//import java.util.Set;
//
//
//@Component
//public class JwtUtill {
//
//    private final String secretKey = Base64.getEncoder().encodeToString(
//            Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded()
//    );
//
//    private final long expiration = 86400000; // 1 day
//
//    private Key getSigningKey() {
//        return Keys.hmacShaKeyFor(secretKey.getBytes());
//    }
//
//    public String generateToken(String username, Set<String> roles) { // ✅ Change roles type to Set<String>
//        String rolesString = String.join(",", roles); // Convert Set to comma-separated String
//        return Jwts.builder()
//                .setSubject(username)
//                .claim("role", rolesString) // ✅ Store roles in token
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(getSigningKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public Set<String> extractRoles(String token) { // ✅ Fix method to extract roles correctly
//        String rolesString = Jwts.parserBuilder()
//                .setSigningKey(getSigningKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .get("role", String.class);
//
//        return Set.of(rolesString.split(",")); // Convert back to Set
//    }
//
//    public boolean validateToken(String token, String username) {
//        try {
//            return extractUsername(token).equals(username);
//        } catch (ExpiredJwtException | SignatureException e) {
//            return false;
//        }
//    }
//}
