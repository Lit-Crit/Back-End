package com.lets_book_it_api.controllers;

import com.lets_book_it_api.business_layer.authentication.AuthenticationService;
import com.lets_book_it_api.data_objects.authentication.AuthenticateRequest;
import com.lets_book_it_api.data_objects.authentication.AuthenticationResponse;
import com.lets_book_it_api.data_objects.register.RegisterRequest;
import com.lets_book_it_api.data_objects.register.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController
{
    @Autowired
    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request)
    {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
