package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTO.UserRequestDTO;
import com.projeto.ecommerce.DTO.UserResponseDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.enums.RoleEnum;
import com.projeto.ecommerce.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDTO> getUser(){
        List<UserEntity> users = userRepo.findAll();
        return users.stream().map(UserResponseDTO::new).toList();
    }

    public String createUser(UserRequestDTO dto, String path){
        UserEntity user = new UserEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(RoleEnum.ROLE_USER);
        user.setPhoto(path);
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
