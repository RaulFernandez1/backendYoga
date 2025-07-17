package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.GrupoDTO;
import com.pruebaTFG.myapp.exceptions.GrupoNotFoundException;
import com.pruebaTFG.myapp.services.impl.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private IGrupoService service;

    @PostMapping
    public ResponseEntity<GrupoDTO> aniadirGrupo(@RequestBody GrupoDTO grupo) {
        GrupoDTO dto = service.addGrupo(grupo);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoDTO> editarGrupo(@PathVariable Long id, @RequestBody GrupoDTO grupo) {
        GrupoDTO dto = service.editGrupo(id, grupo);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGrupo(@PathVariable Long id) {
        service.deleteGrupo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<GrupoDTO>> obtenerTodosGrupos() {
        List<GrupoDTO> listaDTOs = service.getAllGrupos();
        return ResponseEntity.ok(listaDTOs);
    }


    @GetMapping("/buscar")
    public ResponseEntity<GrupoDTO> obtenerGrupo(@RequestParam String nombregrupo) {
        GrupoDTO dto = service.getGrupoByNombregrupo(nombregrupo);
        return ResponseEntity.ok(dto);
    }


    /* ================================================================================================================== */

    @ExceptionHandler(GrupoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void grupoNotFound() {}

}
