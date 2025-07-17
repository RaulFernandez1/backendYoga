package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.MensajeDTO;
import com.pruebaTFG.myapp.exceptions.AlumnoNotFoundException;
import com.pruebaTFG.myapp.exceptions.MensajeNotFoundException;
import com.pruebaTFG.myapp.services.impl.IMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    @Autowired
    private IMensajeService service;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<MensajeDTO>> obtenerTodosMensajesPorIdAlumno(@PathVariable Long id) {
        List<MensajeDTO> mensajes = service.getAllMensajesPorAlumno(id);
        return ResponseEntity.ok(mensajes);
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> crearMensaje(@RequestBody MensajeDTO mensaje) {
        MensajeDTO dto = service.addMensaje(mensaje);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable Long id) {
        service.deleteMensaje(id);
        return ResponseEntity.noContent().build();
    }

    /* ================================================================================================================== */

    @ExceptionHandler(MensajeNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void mensajeNotFound() {}

    @ExceptionHandler(AlumnoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void alumnoNotFound() {}

}
