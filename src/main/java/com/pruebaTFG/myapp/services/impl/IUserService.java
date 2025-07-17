package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.UserDTO;
import com.pruebaTFG.myapp.dtos.UserRegistroDTO;
import com.pruebaTFG.myapp.dtos.UserResponseDTO;
import com.pruebaTFG.myapp.entities.Role;
import com.pruebaTFG.myapp.entities.User;
import com.pruebaTFG.myapp.repository.AlumnoRepository;
import com.pruebaTFG.myapp.repository.UserRepository;
import com.pruebaTFG.myapp.security.JwtUtil;
import com.pruebaTFG.myapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IUserService implements UserService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtil jwtUtils;
    @Autowired
    private AlumnoRepository alumnoRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public String crearUsuario(UserRegistroDTO user) {
        if(userRepo.existsByUsername(user.getUsername())) return null;

        User usuario = User.builder()
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .alumnoId(user.getAlumno_id())
                .rol(user.getRol())
                .build();

        userRepo.save(usuario);

        return "OK";
    }

    @Override
    public UserResponseDTO autenticarUser(UserDTO user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> usuarioBD = userRepo.findByUsername(user.getUsername());
        if(usuarioBD.isEmpty()) return null;

        UserResponseDTO response = UserResponseDTO.builder()
                .token(jwtUtils.generateToken(userDetails.getUsername()))
                .alumno_id(usuarioBD.get().getAlumnoId())
                .build();
        return response;
    }
}
