package com.projeto.ecommerce.DTO;

import com.projeto.ecommerce.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String phone;
    @Size(min = 6, max = 30)
    private String password;
    //  Salvar no banco com as informações do Enum e não com zero, 1, 2...
    @Enumerated(EnumType.STRING)
//  vai servir pra gerenciar as permissões do usuário
    private RoleEnum roles;
}
