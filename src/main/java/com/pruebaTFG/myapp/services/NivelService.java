package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.NivelDTO;
import com.pruebaTFG.myapp.entities.Nivel;

import java.util.List;

public interface NivelService {

    NivelDTO addNiveles(NivelDTO dto);
    NivelDTO editNiveles(Long id, NivelDTO dto);
    void deleteNiveles(Long id);
    List<NivelDTO> getAllNiveles();
    NivelDTO getGrupoByNombrenivelYCondicion(String nombreNivel, String condicion);

}
