package com.pruebaTFG.myapp.mappers;

import com.pruebaTFG.myapp.dtos.MensajeDTO;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Mensaje;
import com.pruebaTFG.myapp.repository.AlumnoRepository;

public class MensajeMapper {

    public static MensajeDTO toDTO(Mensaje mensaje) {
        return MensajeDTO.builder()
                .id(mensaje.getId())
                .asunto(mensaje.getAsunto())
                .contenido(mensaje.getContenido())
                .fechaEnvio(mensaje.getFechaEnvio())
                .leido(mensaje.isLeido())
                .isgrupo(mensaje.isGrupo())
                .isimportante(mensaje.isImportante())
                .alumno_id(mensaje.getAlumno() != null ? mensaje.getAlumno().getId() : null)
                .grupo(mensaje.getGrupo())
                .build();
    }

    public static Mensaje toEntity(MensajeDTO mensajeDTO, AlumnoRepository repoAlumno) {
        Alumno alumno = mensajeDTO.getAlumno_id() != null ? repoAlumno.findById(mensajeDTO.getAlumno_id()).orElse(null) : null;
        System.out.println(Mensaje.builder()
                .id(mensajeDTO.getId())
                .asunto(mensajeDTO.getAsunto())
                .contenido(mensajeDTO.getContenido())
                .fechaEnvio(mensajeDTO.getFechaEnvio())
                .leido(mensajeDTO.isLeido())
                .isGrupo(mensajeDTO.isIsgrupo())
                .isImportante(mensajeDTO.isIsimportante())
                .alumno(alumno)
                .grupo(mensajeDTO.getGrupo())
                .build());
        return Mensaje.builder()
                .id(mensajeDTO.getId())
                .asunto(mensajeDTO.getAsunto())
                .contenido(mensajeDTO.getContenido())
                .fechaEnvio(mensajeDTO.getFechaEnvio())
                .leido(mensajeDTO.isLeido())
                .isGrupo(mensajeDTO.isIsgrupo())
                .isImportante(mensajeDTO.isIsimportante())
                .alumno(alumno)
                .grupo(mensajeDTO.getGrupo())
                .build();
    }

}
