package com.pruebaTFG.myapp.security;

import com.pruebaTFG.myapp.dtos.UserRegistroDTO;
import com.pruebaTFG.myapp.entities.Role;
import com.pruebaTFG.myapp.services.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAlumnoService alumnoService;

    @Autowired
    private INivelService nivelService;

    @Autowired
    private IGrupoService grupoService;

    @Autowired
    private IReciboService reciboService;

    @Autowired
    private IGastoService gastoService;

    @Override
    public void run(String... args) throws Exception {

        /* CREACION DE NIVELES */
        creacionNieveles();

        /* CREACION DE GRUPOS */
        creacionGrupos();

        /* CREACION DE ALUMNOS */
        creacionAlumnos();

        /* CREACION DE USUARIOS */
        creacionUsuarios();

        /* CREACION DE RECIBOS */
        creacionRecibos();

        /* CREACION DE GASTOS */
        creacionGastos();
    }

    private void creacionNieveles() {

    }

    private void creacionGrupos() {

    }

    private void creacionAlumnos() {

    }

    private void creacionUsuarios() {
        UserRegistroDTO admin = UserRegistroDTO.builder()
                .username("admin")
                .password("admin")
                .rol(Role.ENTRENADOR)
                .alumno_id("0")
                .build();
        UserRegistroDTO usuario = UserRegistroDTO.builder()
                .username("usuario")
                .password("usuario")
                .rol(Role.USUARIO)
                .alumno_id("1")
                .build();

        userService.crearUsuario(admin);
        userService.crearUsuario(usuario);
    }

    private void creacionRecibos() {

    }

    private void creacionGastos() {

    }

}
