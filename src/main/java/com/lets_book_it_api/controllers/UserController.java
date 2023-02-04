package com.lets_book_it_api.controllers;

import com.lets_book_it_api.business_layer.user.UserService;
import com.lets_book_it_api.data_objects.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController
{
    @Autowired
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity<UserDTO> getUser()
    {
        return ResponseEntity.ok(userService.getUser());
    }
}
