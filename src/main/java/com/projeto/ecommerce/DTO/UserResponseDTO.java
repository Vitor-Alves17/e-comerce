package com.projeto.ecommerce.DTO;

import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.enums.RoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private RoleEnum roles;

    public UserResponseDTO(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.roles = user.getRoles();
    }
}
