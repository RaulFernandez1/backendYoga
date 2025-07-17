package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.UserDTO;
import com.pruebaTFG.myapp.dtos.UserRegistroDTO;
import com.pruebaTFG.myapp.dtos.UserResponseDTO;
import com.pruebaTFG.myapp.entities.Role;

public interface UserService {

    String crearUsuario(UserRegistroDTO usuario);
    UserResponseDTO autenticarUser(UserDTO user);

}
