package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.NivelDTO;
import com.pruebaTFG.myapp.entities.Nivel;
import com.pruebaTFG.myapp.exceptions.NivelNotFoundException;
import com.pruebaTFG.myapp.mappers.NivelMapper;
import com.pruebaTFG.myapp.repository.NivelRepository;
import com.pruebaTFG.myapp.services.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class INivelService implements NivelService {

    @Autowired
    private NivelRepository repo;

    // Aniadir nuevo nivel
    @Override
    public NivelDTO addNiveles(NivelDTO nivelDTO) {
        Nivel nivel = NivelMapper.toEntity(nivelDTO);
        return NivelMapper.toDTO(repo.save(nivel));
    }

    // Modificar nivel
    @Override
    public NivelDTO editNiveles(Long id, NivelDTO nivelDTO) {
        Nivel nivelBD = buscarPorId(id);
        if(nivelBD == null) throw new NivelNotFoundException();

        nivelDTO.setId(id);
        Nivel nivel = repo.save(NivelMapper.toEntity(nivelDTO));

        return NivelMapper.toDTO(nivel);
    }

    // Eliminar nivel
    @Override
    public void deleteNiveles(Long id) {
        Nivel nivelBD = buscarPorId(id);
        if(nivelBD == null) throw new NivelNotFoundException();

        repo.deleteById(id);
    }


    /*=====================================================================================*/

    @Override
    public List<NivelDTO> getAllNiveles() {
        List<Nivel> niveles = repo.findAll();
        return niveles.stream().map(NivelMapper::toDTO).toList();
    }

    @Override
    public NivelDTO getGrupoByNombrenivelYCondicion(String nombreNivel, String condicion) {
        Optional<Nivel> nivelBD = repo.findByNombrenivelAndCondicion(nombreNivel,condicion);
        if(nivelBD.isEmpty()) throw new NivelNotFoundException();

        return NivelMapper.toDTO(nivelBD.get());
    }

    /*=====================================================================================*/

    private Nivel buscarPorId(Long id) {
        Optional<Nivel> opc = repo.findById(id);
        if(opc.isEmpty()) return null;
        return opc.get();
    }

}
