package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.GrupoDTO;
import com.pruebaTFG.myapp.dtos.NivelDTO;
import com.pruebaTFG.myapp.entities.Nivel;
import com.pruebaTFG.myapp.exceptions.NivelBadRequestException;
import com.pruebaTFG.myapp.exceptions.NivelNotFoundException;
import com.pruebaTFG.myapp.services.impl.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveles")
public class NivelController {

    @Autowired
    private INivelService service;

    @PostMapping
    public ResponseEntity<NivelDTO> aniadirNiveles(@RequestBody NivelDTO niveles) {
        NivelDTO nvl = service.addNiveles(niveles);
        return ResponseEntity.ok(nvl);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NivelDTO> editarNiveles(@PathVariable Long id, @RequestBody NivelDTO niveles) {
        NivelDTO nvl = service.editNiveles(id,niveles);
        return ResponseEntity.ok(nvl);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNiveles(@PathVariable(name = "id") Long nivelId) {
        service.deleteNiveles(nivelId);
        return ResponseEntity.noContent().build();
    }

    /*================================================================================================================*/

    @GetMapping
    public ResponseEntity<List<NivelDTO>> obtenerTodosNiveles() {
        List<NivelDTO> lista = service.getAllNiveles();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<NivelDTO> obtenerNivel(@RequestParam String nombrenivel, @RequestParam String condicion) {
        NivelDTO dto = service.getGrupoByNombrenivelYCondicion(nombrenivel,condicion);
        return ResponseEntity.ok(dto);
    }

    /*================================================================================================================*/

    @ExceptionHandler(NivelNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void nivelesNoEncontrado() {}

    @ExceptionHandler(NivelBadRequestException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public void nivelesNoAceptable() {}

}
