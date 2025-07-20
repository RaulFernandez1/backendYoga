package com.pruebaTFG.myapp.mappers;

import com.pruebaTFG.myapp.dtos.AlumnoDTO;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Grupo;
import com.pruebaTFG.myapp.repository.AlumnoRepository;
import com.pruebaTFG.myapp.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AlumnoMapper {


    public static AlumnoDTO toDTO(Alumno alumno) {
        return AlumnoDTO.builder()
                .id(alumno.getId())
                .dni(alumno.getDni())
                .nombre(alumno.getNombre())
                .apellido1(alumno.getApellido1())
                .apellido2(alumno.getApellido2())
                .fechanacimiento(alumno.getFechanacimiento())
                .profesion(alumno.getProfesion())
                .direccion(alumno.getDireccion())
                .poblacion(alumno.getPoblacion())
                .provincia(alumno.getProvincia())
                .codigopostal(alumno.getCodigopostal())
                .correo(alumno.getCorreo())
                .telefono1(alumno.getTelefono1())
                .telefono2(alumno.getTelefono2())
                .fechaalta(alumno.getFechaalta())
                .fechabaja(alumno.getFechabaja())
                .condicion(alumno.getCondicion())
                .precio(alumno.getPrecio())
                .activo(alumno.getActivo())
                .bonos(alumno.getBonos())
                .mensualidad(alumno.getMensualidad())
                .clases(alumno.getClases())
                .grupo_id((alumno.getGrupo() != null)? alumno.getGrupo().getId() : null)
                .build();
    }

    public static Alumno toEntity(AlumnoDTO alumno, GrupoRepository repoGrupo) {
        Grupo grupo = alumno.getGrupo_id() != null ? repoGrupo.findById(alumno.getGrupo_id()).orElse(null) : null;

        return Alumno.builder()
                .id(alumno.getId())
                .dni(alumno.getDni())
                .nombre(alumno.getNombre())
                .apellido1(alumno.getApellido1())
                .apellido2(alumno.getApellido2())
                .fechanacimiento(alumno.getFechanacimiento())
                .profesion(alumno.getProfesion())
                .direccion(alumno.getDireccion())
                .poblacion(alumno.getPoblacion())
                .provincia(alumno.getProvincia())
                .codigopostal(alumno.getCodigopostal())
                .correo(alumno.getCorreo())
                .telefono1(alumno.getTelefono1())
                .telefono2(alumno.getTelefono2())
                .fechaalta(alumno.getFechaalta())
                .fechabaja(alumno.getFechabaja())
                .condicion(alumno.getCondicion())
                .precio(alumno.getPrecio())
                .activo(alumno.isActivo())
                .bonos(alumno.isBonos())
                .mensualidad(alumno.isMensualidad())
                .clases(alumno.isClases())
                .grupo(grupo)
                .build();
    }

}
