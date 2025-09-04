package com.pruebaTFG.myapp.security;

import com.pruebaTFG.myapp.dtos.*;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Role;
import com.pruebaTFG.myapp.services.impl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        NivelDTO nivelElemental = NivelDTO.builder()
                .nombrenivel("Nivel Elemental")
                .condicion("Principiante")
                .preciomensualidad(20f)
                .precioclases(25f)
                .preciobonos(23f)
                .build();
        NivelDTO nivelIntermedio = NivelDTO.builder()
                .nombrenivel("Nivel Intermedio")
                .condicion("Intermedio")
                .preciomensualidad(25f)
                .precioclases(30f)
                .preciobonos(26f)
                .build();
        NivelDTO nivelSuperior = NivelDTO.builder()
                .nombrenivel("Nivel Superior")
                .condicion("Avanzado")
                .preciomensualidad(30f)
                .precioclases(35f)
                .preciobonos(29f)
                .build();
        NivelDTO nivelMayores59 = NivelDTO.builder()
                .nombrenivel("Nivel Mayores 59")
                .condicion("Especial")
                .preciomensualidad(20f)
                .precioclases(25f)
                .preciobonos(23f)
                .build();
        NivelDTO nivelIndividual = NivelDTO.builder()
                .nombrenivel("Nivel Individual")
                .condicion("Individual")
                .preciomensualidad(35f)
                .precioclases(40f)
                .preciobonos(37f)
                .build();

        nivelService.addNiveles(nivelElemental);
        nivelService.addNiveles(nivelIntermedio);
        nivelService.addNiveles(nivelSuperior);
        nivelService.addNiveles(nivelMayores59);
        nivelService.addNiveles(nivelIndividual);
    }

    private void creacionGrupos() {
        GrupoDTO elemental1 = GrupoDTO.builder()
                .nombregrupo("Elemental I")
                .horario("Lunes y Martes")
                .nivel("Nivel Elemental")
                .build();
        GrupoDTO elemental2 = GrupoDTO.builder()
                .nombregrupo("Elemental II")
                .horario("Jueves y Viernes")
                .nivel("Nivel Elemental")
                .build();
        GrupoDTO intermedio1 = GrupoDTO.builder()
                .nombregrupo("Intermedio I")
                .horario("Lunes y Martes")
                .nivel("Nivel Intermedio")
                .build();
        GrupoDTO intermedio2 = GrupoDTO.builder()
                .nombregrupo("Intermedio II")
                .horario("Jueves y Viernes")
                .nivel("Nivel Intermedio")
                .build();

        grupoService.addGrupo(elemental1);
        grupoService.addGrupo(elemental2);
        grupoService.addGrupo(intermedio1);
        grupoService.addGrupo(intermedio2);
    }

    private void creacionAlumnos() {
        AlumnoDTO alumno1 = AlumnoDTO.builder()
                .dni("66894531F")
                .nombre("Javier")
                .apellido1("Fernandez")
                .apellido2("Lopez")
                .correo("javifer@gmail.com")
                .fechanacimiento(LocalDate.of(2001,4,28))
                .profesion("Ingeniero Quimico")
                .direccion("Calle Olvido 1, bloque Pedrosa")
                .poblacion("Marbella")
                .provincia("Malaga")
                .codigopostal("34567")
                .telefono1("678986756")
                .telefono2("678999756")
                .fechaalta(LocalDate.of(2025,1,23))
                .fechabaja(null)
                .condicion("Buena")
                .grupo_id(21L)
                .precio(20)
                .activo(true)
                .mensualidad(true)
                .bonos(false)
                .clases(false)
                .build();

        alumnoService.addAlumno(alumno1);
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
        GastoDTO gasto1 = GastoDTO.builder()
                .cantidadgasto(150f)
                .descripcion("Factura de la luz.")
                .fechagasto(LocalDate.of(2025,2,12))
                .build();

        GastoDTO gasto2 = GastoDTO.builder()
                .cantidadgasto(168f)
                .descripcion("Factura de la luz.")
                .fechagasto(LocalDate.of(2025,3,12))
                .build();

        GastoDTO gasto3 = GastoDTO.builder()
                .cantidadgasto(50f)
                .descripcion("Compra de material para las clases.")
                .fechagasto(LocalDate.of(2025,3,22))
                .build();

        GastoDTO gasto4 = GastoDTO.builder()
                .cantidadgasto(90f)
                .descripcion("Factura de la red.")
                .fechagasto(LocalDate.of(2025,5,3))
                .build();

        gastoService.addGastos(gasto1);
        gastoService.addGastos(gasto2);
        gastoService.addGastos(gasto3);
        gastoService.addGastos(gasto4);
    }

}
