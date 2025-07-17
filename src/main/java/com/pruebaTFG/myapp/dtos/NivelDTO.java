package com.pruebaTFG.myapp.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NivelDTO {
    private Long id;
    private String nombrenivel;
    private String condicion;
    private Float preciomensualidad;
    private Float preciobonos;
    private Float precioclases;
}
