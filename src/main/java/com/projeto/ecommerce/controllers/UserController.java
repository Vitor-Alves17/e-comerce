package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.UserRequestDTO;
import com.projeto.ecommerce.DTO.UserResponseDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.PhotoService;
import com.projeto.ecommerce.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final PhotoService photoService;

    @GetMapping("/showall")
    public List<UserResponseDTO> showall(){
        return service.getUser();
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserRequestDTO req, @RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(req, photoService.uploadPhoto(file)));
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
