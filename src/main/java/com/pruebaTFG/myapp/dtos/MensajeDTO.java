package com.pruebaTFG.myapp.dtos;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class MensajeDTO {

    private Long id;

    private String asunto;
    private String contenido;

    private LocalDateTime fechaEnvio;
    private boolean leido;
    private boolean isgrupo;
    private boolean isimportante;

    private Long alumno_id;
    private Long grupo;
}
