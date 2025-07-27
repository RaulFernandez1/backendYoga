package com.pruebaTFG.myapp.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmailMensajeRequest {
    private String to;
    private String subject;

    private String letra;
    private String nombre;
    private String rol;
    private LocalDateTime fechaHora;
    private String asunto;
    private String contenido;

    private boolean importante;
    private boolean leido;
    private boolean grupo;
}
