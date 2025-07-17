package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.GastoDTO;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface GastosService {

    GastoDTO addGastos(GastoDTO dto);

    GastoDTO getGasto(LocalDate fechagasto, String descripcion, Float cantidadgasto);

    List<GastoDTO> getAllGastos();
    void deleteGastoById(Long id);
    void deleteGastoByPK(LocalDate fechagasto, String descripcion, Float cantidadgasto);

}
