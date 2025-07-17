package com.pruebaTFG.myapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
        (
                name = "grupos",
                uniqueConstraints = {
                        @UniqueConstraint(columnNames = {"nombregrupo"})
                }
        )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombregrupo;

    private String horario;

    private String nivel;

}
