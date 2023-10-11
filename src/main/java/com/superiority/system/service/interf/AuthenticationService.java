package com.superiority.system.service.interf;

import com.superiority.system.web.dto.JWTRequest;
import com.superiority.system.web.dto.JWTResponse;

public interface AuthenticationService {
    JWTResponse login(JWTRequest loginRequest);
    JWTResponse refresh(String refreshToken);
}
