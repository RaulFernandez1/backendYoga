package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.AlumnoDTO;
import com.pruebaTFG.myapp.exceptions.AlumnoNotFoundException;
import com.pruebaTFG.myapp.services.impl.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoService service;

    @PostMapping
    public ResponseEntity<AlumnoDTO> aniadirAlumno(@RequestBody AlumnoDTO alumno) {
        AlumnoDTO dto = service.addAlumno(alumno);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> editarAlumno(@PathVariable Long id, @RequestBody AlumnoDTO alumno) {
        AlumnoDTO dto = service.editAlumno(id, alumno);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> obtenerTodosAlumnos() {
        List<AlumnoDTO> listaDTOs = service.getAllAlumnos();
        return ResponseEntity.ok(listaDTOs);
    }

    @GetMapping("/buscar")
    public ResponseEntity<AlumnoDTO> obtenerAlumno(@RequestParam String dni) {
        AlumnoDTO dto = service.getAlumnoByDni(dni);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> obtenerAlumnoPorid(@PathVariable Long id) {
        AlumnoDTO dto = service.getAlumnoById(id);
        return ResponseEntity.ok(dto);
    }


    /*================================================================================================================*/

    @ExceptionHandler(AlumnoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void alumnoNoEncontrado() {}

}
