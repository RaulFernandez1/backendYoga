package com.pruebaTFG.myapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String asunto;
    @Column(columnDefinition = "TEXT")
    private String contenido;

    private LocalDateTime fechaEnvio;
    private boolean leido;

    @Column(name = "is_grupo")
    @Access(AccessType.FIELD)
    private boolean isGrupo;
    @Column(name = "is_importante")
    @Access(AccessType.FIELD)
    private boolean isImportante;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    private Long grupo;
}
