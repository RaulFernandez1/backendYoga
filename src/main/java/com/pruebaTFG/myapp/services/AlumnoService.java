package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.AlumnoDTO;

import java.util.List;

public interface AlumnoService {

    AlumnoDTO addAlumno(AlumnoDTO alumno);

    AlumnoDTO editAlumno(Long id, AlumnoDTO alumno);

    List<AlumnoDTO> getAllAlumnos();
    AlumnoDTO getAlumnoByDni(String dni);
    AlumnoDTO getAlumnoById(Long id);

}
