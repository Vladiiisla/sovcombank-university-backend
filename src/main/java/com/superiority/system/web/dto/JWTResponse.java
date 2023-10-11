package com.superiority.system.web.dto;

import lombok.Data;

@Data
public class JWTResponse {
    private Long id;
    private String email;
    private String accessToken;
    private String refreshToken;
}
