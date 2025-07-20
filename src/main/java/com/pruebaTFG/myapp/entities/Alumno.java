package com.pruebaTFG.myapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
        (
                name = "alumnos",
                uniqueConstraints = {
                        @UniqueConstraint(columnNames = {"dni"})
                }

        )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
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
    private Float precio;
    private Boolean activo;
    private Boolean mensualidad;
    private Boolean bonos;
    private Boolean clases;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

}
