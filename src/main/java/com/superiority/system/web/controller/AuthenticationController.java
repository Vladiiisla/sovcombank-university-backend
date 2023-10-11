package com.superiority.system.web.controller;

import com.superiority.system.domain.user.User;
import com.superiority.system.service.interf.AuthenticationService;
import com.superiority.system.service.interf.UserService;
import com.superiority.system.web.dto.JWTRequest;
import com.superiority.system.web.dto.JWTResponse;
import com.superiority.system.web.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
//    private final UserMapper userMapper;

    @PostMapping("/login")
    public JWTResponse login(@Validated @RequestBody JWTRequest loginRequest){
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User userDto){
        userService.create(userDto);
        return new ResponseEntity<>(new MessageResponse("User register!!!", HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public JWTResponse refresh(@RequestBody String refreshToken){
        return authenticationService.refresh(refreshToken);
    }


}
