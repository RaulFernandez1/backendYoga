package com.pruebaTFG.myapp.mappers;

import com.pruebaTFG.myapp.dtos.NivelDTO;
import com.pruebaTFG.myapp.entities.Nivel;

public class NivelMapper {

    public static NivelDTO toDTO(Nivel nivel) {
        return NivelDTO.builder()
                .id(nivel.getId())
                .nombrenivel(nivel.getNombrenivel())
                .condicion(nivel.getCondicion())
                .preciomensualidad(nivel.getPreciomensualidad())
                .preciobonos(nivel.getPreciobonos())
                .precioclases(nivel.getPrecioClases())
                .build();
    }

    public static Nivel toEntity(NivelDTO dto) {
        return Nivel.builder()
                .id(dto.getId())
                .nombrenivel(dto.getNombrenivel())
                .condicion(dto.getCondicion())
                .preciomensualidad(dto.getPreciomensualidad())
                .preciobonos(dto.getPreciobonos())
                .precioClases(dto.getPrecioclases())
                .build();
    }
}
