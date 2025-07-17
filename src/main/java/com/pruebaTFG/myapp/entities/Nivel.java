package com.pruebaTFG.myapp.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
        (
                name = "niveles",
                uniqueConstraints = {
                        @UniqueConstraint(columnNames = {"nombre_nivel", "condicion"})
                }
        )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_nivel", nullable = false)
    private String nombrenivel;
    @Column(name = "condicion", nullable = false)
    private String condicion;

    @Column(name = "precio_mensualidad")
    private Float preciomensualidad;
    @Column(name = "precio_bonos")
    private Float preciobonos;
    @Column(name = "precio_clases")
    private Float precioClases;
}

