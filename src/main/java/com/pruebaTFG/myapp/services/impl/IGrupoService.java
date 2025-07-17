package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.GrupoDTO;
import com.pruebaTFG.myapp.entities.Grupo;
import com.pruebaTFG.myapp.exceptions.GrupoNotFoundException;
import com.pruebaTFG.myapp.mappers.GrupoMapper;
import com.pruebaTFG.myapp.repository.GrupoRepository;
import com.pruebaTFG.myapp.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IGrupoService implements GrupoService {

    @Autowired
    private GrupoRepository repo;

    @Override
    public GrupoDTO addGrupo(GrupoDTO dto) {
        Grupo grupo = GrupoMapper.toEntity(dto);
        return GrupoMapper.toDTO(repo.save(grupo));
    }

    @Override
    public GrupoDTO editGrupo(Long id, GrupoDTO grupoDTO) {
        Grupo grupoBD = buscarPorId(id);
        if(grupoBD == null) throw new GrupoNotFoundException();

        grupoDTO.setId(id);
        Grupo grupo = repo.save(GrupoMapper.toEntity(grupoDTO));

        return GrupoMapper.toDTO(grupo);
    }

    @Override
    public void deleteGrupo(Long id) {
        Grupo grupoBD = buscarPorId(id);
        if(grupoBD == null) throw new GrupoNotFoundException();

        repo.deleteById(id);
    }

    @Override
    public List<GrupoDTO> getAllGrupos() {
        List<Grupo> grupos = repo.findAll();
        return grupos.stream().map(GrupoMapper::toDTO).toList();
    }

    @Override
    public GrupoDTO getGrupoByNombregrupo(String nombregrupo) {
        Optional<Grupo> grupoBD = repo.findByNombregrupo(nombregrupo);
        if(grupoBD.isEmpty()) throw new GrupoNotFoundException();

        return GrupoMapper.toDTO(grupoBD.get());
    }



    /*=====================================================================================*/

    private Grupo buscarPorId(Long id) {
        Optional<Grupo> opc = repo.findById(id);
        if(opc.isEmpty()) return null;
        return opc.get();
    }

}
