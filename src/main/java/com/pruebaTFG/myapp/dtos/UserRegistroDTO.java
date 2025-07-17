package com.pruebaTFG.myapp.dtos;

import com.pruebaTFG.myapp.entities.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegistroDTO {
    private String username;
    private String password;
    private String alumno_id;
    private Role rol;
}
