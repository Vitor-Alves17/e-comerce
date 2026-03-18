package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTO.UserRequestDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEntity> getUser(){
        List<UserEntity> users = userRepo.findAll();
        return users;
    }

    public String createUser(UserRequestDTO dto){
        UserEntity user = new UserEntity(dto);
        userRepo.save(user);
        return "User created sucefully";
    }
}
