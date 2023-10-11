package com.superiority.system.security.JWT;

import com.superiority.system.domain.exception.AccessDeniedException;
import com.superiority.system.domain.user.Role;
import com.superiority.system.domain.user.User;
import com.superiority.system.service.interf.UserService;
import com.superiority.system.web.dto.JWTResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private Key key;
    @PostConstruct
    public void init(){
        this.key= Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
    }
    public String createAccessToken(Long userId, String email, Set<Role> roles){
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("id",userId);
        claims.put("roles",resolveRoles(roles));
        Instant validity = Instant.now()
                .plus(jwtProperties.getAccess(), ChronoUnit.HOURS);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(Date.from(validity))
                .signWith(key)
                .compact();
    }

    private List<String> resolveRoles(Set<Role> roles) {
        return roles.stream()
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public String createRefreshToken(Long userId,String username){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("id",userId);
        Instant validity = Instant.now()
                .plus(jwtProperties.getRefresh(), ChronoUnit.DAYS);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(Date.from(validity))
                .signWith(key)
                .compact();
    }

    public JWTResponse refreshUserTokens(String refreshToken){
        JWTResponse jwtResponse= new JWTResponse();
        if(!validateToken(refreshToken)){
            throw new AccessDeniedException();
        }
        Long userId = Long.valueOf(getId(refreshToken));
        User user = userService.findById(userId);
        jwtResponse.setId(userId);
        jwtResponse.setEmail(user.getEmail());
        jwtResponse.setAccessToken(createAccessToken(userId,user.getEmail(),user.getRoles()));
        jwtResponse.setRefreshToken(createRefreshToken(userId,user.getEmail()));
        return jwtResponse;
    }

    private String getId(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("id")
                .toString();
    }

    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return !claims.getBody().getExpiration().before(new Date());
    }

    public Authentication getAuthentication(String token){
        String username = getUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    private String getUsername(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

