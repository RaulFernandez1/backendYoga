package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.AlumnoDTO;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.exceptions.AlumnoNotFoundException;
import com.pruebaTFG.myapp.mappers.AlumnoMapper;
import com.pruebaTFG.myapp.repository.AlumnoRepository;
import com.pruebaTFG.myapp.repository.GrupoRepository;
import com.pruebaTFG.myapp.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class IAlumnoService implements AlumnoService {

    @Autowired
    private AlumnoRepository repoAlumno;

    @Autowired
    private GrupoRepository repoGrupo;

    @Override
    public AlumnoDTO addAlumno(AlumnoDTO alumno) {
        if(repoAlumno.findByDni(alumno.getDni()).isPresent()) return null;
        Alumno alumnoDB = AlumnoMapper.toEntity(alumno,repoGrupo);
        return AlumnoMapper.toDTO(repoAlumno.save(alumnoDB));
    }

    @Override
    public AlumnoDTO editAlumno(Long id, AlumnoDTO alumnoDTO) {
        Alumno alumnoBD = buscarPorId(id);
        if(alumnoBD == null) throw new AlumnoNotFoundException();

        alumnoDTO.setId(id);
        Alumno alumno = repoAlumno.save(AlumnoMapper.toEntity(alumnoDTO,repoGrupo));

        return AlumnoMapper.toDTO(alumno);
    }

    @Override
    public List<AlumnoDTO> getAllAlumnos() {
        List<Alumno> alumnos = repoAlumno.findAll();
        return alumnos.stream().map(AlumnoMapper::toDTO).toList();
    }

    @Override
    public AlumnoDTO getAlumnoByDni(String dni) {
        Optional<Alumno> alumnoBD = repoAlumno.findByDni(dni);
        if(alumnoBD.isEmpty()) throw new AlumnoNotFoundException();

        return AlumnoMapper.toDTO(alumnoBD.get());
    }

    @Override
    public AlumnoDTO getAlumnoById(Long id) {
        Optional<Alumno> alumnoBD = repoAlumno.findById(id);
        if(alumnoBD.isEmpty()) throw new AlumnoNotFoundException();

        return AlumnoMapper.toDTO(alumnoBD.get());
    }

    /*=====================================================================================*/

    private Alumno buscarPorId(Long id) {
        Optional<Alumno> opc = repoAlumno.findById(id);
        if(opc.isEmpty()) return null;
        return opc.get();
    }



}