package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.UserRequestDTO;
import com.projeto.ecommerce.DTO.UserResponseDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/showall")
    public List<UserResponseDTO> showall(){
        return service.getUser();
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequestDTO req){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(req));
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequestDTO dto, @PathVariable UUID id){
        return ResponseEntity.ok(service.updateUser(dto, id));
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteUserById(id));
    }
}
