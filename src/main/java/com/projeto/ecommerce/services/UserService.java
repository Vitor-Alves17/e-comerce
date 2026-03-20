package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTO.UserRequestDTO;
import com.projeto.ecommerce.DTO.UserResponseDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserResponseDTO> getUser(){
        List<UserEntity> users = userRepo.findAll();
        return users.stream().map(UserResponseDTO::new).toList();
    }

    public String createUser(UserRequestDTO dto){
        UserEntity user = new UserEntity(dto);
        userRepo.save(user);
        return "User created sucefully";
    }

    public String updateUser(UserRequestDTO dto, UUID id){
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User o found"));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        userRepo.save(user);
        return "update sucefully";
    }

    public String deleteUserById(UUID id){
        if (userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "User deleted sucefully";
        }else {
            return "User not found";
        }
    }
}
