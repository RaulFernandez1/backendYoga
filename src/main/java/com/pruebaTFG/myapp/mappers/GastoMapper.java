package com.pruebaTFG.myapp.mappers;

import com.pruebaTFG.myapp.dtos.GastoDTO;
import com.pruebaTFG.myapp.entities.Gasto;

public class GastoMapper {

    public static GastoDTO toDTO (Gasto gasto) {
        return GastoDTO.builder()
                .id(gasto.getId())
                .fechagasto(gasto.getFechagasto())
                .descripcion(gasto.getDescripcion())
                .cantidadgasto(gasto.getCantidadgasto())
                .build();
    }

    public static Gasto toEntity(GastoDTO dto) {
        return Gasto.builder()
                .id(dto.getId())
                .fechagasto(dto.getFechagasto())
                .descripcion(dto.getDescripcion())
                .cantidadgasto(dto.getCantidadgasto())
                .build();
    }

}
