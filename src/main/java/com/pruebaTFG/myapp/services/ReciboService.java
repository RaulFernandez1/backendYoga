package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.ReciboDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReciboService {

    ReciboDTO addRecibo(ReciboDTO dto);
    List<ReciboDTO> generarRecibos(LocalDate fecha);
    ReciboDTO editRecibo(Long id, ReciboDTO dto);
    List<ReciboDTO> getAllRecibos();
    ReciboDTO getRecibo(String numerorecibo);
    void eliminarRecibo(Long id);

}
