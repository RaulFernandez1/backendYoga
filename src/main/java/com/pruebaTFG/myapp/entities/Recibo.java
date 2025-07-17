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
                name = "recibos",
                uniqueConstraints = {
                        @UniqueConstraint(columnNames = {"numerorecibo"})
                }
        )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numerorecibo;

    private Boolean pagado;
    private Float cantidad;
    private LocalDate fecharecibo;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;
}
