package com.superiority.system.service.implementation;

import com.superiority.system.domain.user.User;
import com.superiority.system.security.JWT.JwtTokenProvider;
import com.superiority.system.service.interf.AuthenticationService;
import com.superiority.system.service.interf.UserService;
import com.superiority.system.web.dto.JWTRequest;
import com.superiority.system.web.dto.JWTResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplementation implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JWTResponse login(JWTRequest loginRequest) {
        JWTResponse jwtResponse = new JWTResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        User user = userService.getByEmail(loginRequest.getEmail());
        jwtResponse.setId(user.getId());
        jwtResponse.setEmail(user.getEmail());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(),user.getEmail(),user.getRoles()));
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(),user.getEmail()));
        return jwtResponse;

    }

    @Override
    public JWTResponse refresh(String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
