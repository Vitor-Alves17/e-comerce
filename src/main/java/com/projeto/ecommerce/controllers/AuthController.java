package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.LoginDTO;
import com.projeto.ecommerce.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager autManeger;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto){
        autManeger.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );
        return jwtService.genereteToken(dto.getEmail());
    }
}
