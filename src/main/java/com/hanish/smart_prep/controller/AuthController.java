package com.hanish.smart_prep.controller;

import com.hanish.smart_prep.dto.AuthRequest;
import com.hanish.smart_prep.dto.AuthResponse;
import com.hanish.smart_prep.entity.User;
import com.hanish.smart_prep.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request){
        User user = authService.register(request.username(), request.password());
        return ResponseEntity.ok("Success! User '" + user.getUsername() + "' registered. You can now login.");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        String token = authService.login(request.username(), request.password());
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
