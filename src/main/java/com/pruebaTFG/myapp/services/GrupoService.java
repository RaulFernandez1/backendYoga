package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.GrupoDTO;

import java.util.List;

public interface GrupoService {

    GrupoDTO addGrupo(GrupoDTO dto);
    GrupoDTO editGrupo(Long id, GrupoDTO dto);
    void deleteGrupo(Long id);
    List<GrupoDTO> getAllGrupos();
    GrupoDTO getGrupoByNombregrupo(String nombregrupo);

}
