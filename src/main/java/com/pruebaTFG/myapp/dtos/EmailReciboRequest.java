package com.pruebaTFG.myapp.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmailReciboRequest {
    private String to;
    private String subject;

    private String nombre;
    private String apellido1;
    private String apellido2;

    private float importe;
    private LocalDate fecha;

    private String nivel;
}
