package com.pruebaTFG.myapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table
        (
                name = "gastos",
                uniqueConstraints = {
                        @UniqueConstraint(columnNames = {"fecha_gasto", "descripcion","cantidad_gasto"})
                }
        )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_gasto")
    private LocalDate fechagasto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad_gasto")
    private Float cantidadgasto;
}
