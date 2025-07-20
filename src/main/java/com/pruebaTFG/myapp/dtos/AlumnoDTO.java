package com.pruebaTFG.myapp.dtos;

import com.pruebaTFG.myapp.entities.Grupo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AlumnoDTO {

    private Long id;

    private String dni;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechanacimiento;
    private String profesion;
    private String direccion;
    private String poblacion;
    private String provincia;
    private String codigopostal;
    private String correo;
    private String telefono1;
    private String telefono2;
    private LocalDate fechaalta;
    private LocalDate fechabaja;

    private String condicion;
    private float precio;
    private boolean activo;
    private boolean mensualidad;
    private boolean bonos;
    private boolean clases;

    private Long grupo_id;

}
