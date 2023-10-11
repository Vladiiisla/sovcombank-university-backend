package com.superiority.system.web.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class JWTRequest {
    private String email;
    private String password;
}


