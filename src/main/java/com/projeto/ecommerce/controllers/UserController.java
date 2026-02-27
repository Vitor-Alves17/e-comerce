package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.UserRequestDTO;
import com.projeto.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }



    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequestDTO req){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(req));
    }
}
