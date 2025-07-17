package com.pruebaTFG.myapp.mappers;

import com.pruebaTFG.myapp.dtos.MensajeDTO;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Mensaje;
import com.pruebaTFG.myapp.repository.AlumnoRepository;

public class MensajeMapper {

    public static MensajeDTO toDTO(Mensaje mensaje) {
        return MensajeDTO.builder()
                .id(mensaje.getId())
                .contenido(mensaje.getContenido())
                .fechaEnvio(mensaje.getFechaEnvio())
                .alumno_id(mensaje.getAlumno() != null ? mensaje.getAlumno().getId() : null)
                .build();
    }

    public static Mensaje toEntity(MensajeDTO mensajeDTO, AlumnoRepository repoAlumno) {
        Alumno alumno = mensajeDTO.getAlumno_id() != null ? repoAlumno.findById(mensajeDTO.getAlumno_id()).orElse(null) : null;
        return Mensaje.builder()
                .id(mensajeDTO.getId())
                .contenido(mensajeDTO.getContenido())
                .fechaEnvio(mensajeDTO.getFechaEnvio())
                .alumno(alumno)
                .build();
    }

}
