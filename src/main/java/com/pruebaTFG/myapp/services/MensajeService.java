package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.MensajeDTO;

import java.util.List;

public interface MensajeService {

    List<MensajeDTO> getAllMensajesPorAlumno(Long alumno_id);
    MensajeDTO addMensaje(MensajeDTO mensaje);
    void deleteMensaje(Long id);

}
