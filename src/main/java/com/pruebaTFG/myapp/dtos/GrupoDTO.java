package com.pruebaTFG.myapp.dtos;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GrupoDTO {

    private Long id;

    private String nombregrupo;
    private String horario;
    private String nivel;
}
