package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.GastoDTO;
import com.pruebaTFG.myapp.entities.Gasto;
import com.pruebaTFG.myapp.exceptions.GastoNotFoundException;
import com.pruebaTFG.myapp.mappers.GastoMapper;
import com.pruebaTFG.myapp.repository.GastoRepository;
import com.pruebaTFG.myapp.services.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IGastoService implements GastosService {

    @Autowired
    private GastoRepository repo;

    @Override
    public GastoDTO addGastos(GastoDTO dto) {
        if(repo.findByFechagastoAndDescripcionAndCantidadgasto(dto.getFechagasto(), dto.getDescripcion(), dto.getCantidadgasto()).isPresent()) return null;
        Gasto gasto = GastoMapper.toEntity(dto);
        return GastoMapper.toDTO(repo.save(gasto));
    }

    @Override
    public GastoDTO getGasto(LocalDate fechagasto, String descripcion, Float cantidadgasto) {
        Optional<Gasto> gastoBD = repo.findByFechagastoAndDescripcionAndCantidadgasto(fechagasto, descripcion, cantidadgasto);
        if(gastoBD.isEmpty()) throw new GastoNotFoundException();

        return GastoMapper.toDTO(gastoBD.get());
    }

    @Override
    public List<GastoDTO> getAllGastos() {
        List<Gasto> gastos = repo.findAll();
        return gastos.stream().map(GastoMapper::toDTO).toList();
    }

    @Override
    public void deleteGastoByPK(LocalDate fechagasto, String descripcion, Float cantidadgasto) {
        Optional<Gasto> gastoBD = repo.findByFechagastoAndDescripcionAndCantidadgasto(fechagasto, descripcion, cantidadgasto);
        if(gastoBD.isEmpty()) throw new GastoNotFoundException();

        repo.deleteById(gastoBD.get().getId());
    }

    @Override
    public void deleteGastoById(Long id) {
        repo.deleteById(id);
    }

    /*=====================================================================================*/

    private Gasto buscarPorId(Long id) {
        Optional<Gasto> opc = repo.findById(id);
        if(opc.isEmpty()) return null;
        return opc.get();
    }


}
