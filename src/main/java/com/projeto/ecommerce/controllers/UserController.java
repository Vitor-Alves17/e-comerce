package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.UserRequestDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/showall")
    public List<UserEntity> showall(){
        return service.getUser();
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequestDTO req){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(req));
    }
}
