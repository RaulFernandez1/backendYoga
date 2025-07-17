package com.pruebaTFG.myapp.mappers;

import com.pruebaTFG.myapp.dtos.ReciboDTO;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Recibo;
import com.pruebaTFG.myapp.repository.AlumnoRepository;

public class ReciboMapper {

    public static ReciboDTO toDTO(Recibo recibo) {
        return ReciboDTO.builder()
                .id(recibo.getId())
                .numerorecibo(recibo.getNumerorecibo())
                .fecharecibo(recibo.getFecharecibo())
                .cantidad(recibo.getCantidad())
                .pagado(recibo.getPagado())
                .alumno(recibo.getAlumno().getId())
                .build();
    }

    public static Recibo toEntity(ReciboDTO dto, AlumnoRepository alumnoRepository) {
        Alumno alumno = dto.getAlumno() != null ? alumnoRepository.findById(dto.getAlumno()).orElse(null) : null;
        return Recibo.builder()
                .id(dto.getId())
                .numerorecibo(dto.getNumerorecibo())
                .fecharecibo(dto.getFecharecibo())
                .cantidad(dto.getCantidad())
                .pagado(dto.getPagado())
                .alumno(alumno)
                .build();
    }

}
