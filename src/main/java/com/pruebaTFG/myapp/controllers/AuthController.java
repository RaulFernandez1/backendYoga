package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.UserDTO;
import com.pruebaTFG.myapp.dtos.UserRegistroDTO;
import com.pruebaTFG.myapp.dtos.UserResponseDTO;
import com.pruebaTFG.myapp.exceptions.UserBadRequestException;
import com.pruebaTFG.myapp.exceptions.UserNotFoundException;
import com.pruebaTFG.myapp.services.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/signin")
    public ResponseEntity<UserResponseDTO> authenticateUser(@RequestBody UserDTO user ) {
        UserResponseDTO response = userService.autenticarUser(user);
        if(response == null) throw new UserNotFoundException();

        return ResponseEntity.ok(response);
    }
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistroDTO user) {
        String status = userService.crearUsuario(user);
        if(status == null) throw new UserBadRequestException();
        return ResponseEntity.ok("User registered successfully!");
    }

    /* ================================================================================================================== */

    @ExceptionHandler(UserBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void userBadRequest() {}

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void userNotFound() {}
}
