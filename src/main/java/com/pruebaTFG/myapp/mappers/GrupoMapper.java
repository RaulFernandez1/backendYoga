package com.pruebaTFG.myapp.mappers;

import com.pruebaTFG.myapp.dtos.GrupoDTO;
import com.pruebaTFG.myapp.entities.Grupo;

public class GrupoMapper {

    public static GrupoDTO toDTO(Grupo grupo) {
        return GrupoDTO.builder()
                .id(grupo.getId())
                .nombregrupo(grupo.getNombregrupo())
                .horario(grupo.getHorario())
                .nivel(grupo.getNivel())
                .build();
    }

    public static Grupo toEntity(GrupoDTO dto) {
        return Grupo.builder()
                .id(dto.getId())
                .nombregrupo(dto.getNombregrupo())
                .horario(dto.getHorario())
                .nivel(dto.getNivel())
                .build();
    }

}
