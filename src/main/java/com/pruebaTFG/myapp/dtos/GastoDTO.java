package com.pruebaTFG.myapp.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class GastoDTO {

    private Long id;
    private LocalDate fechagasto;
    private String descripcion;
    private Float cantidadgasto;

}
