package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.ReciboDTO;
import com.pruebaTFG.myapp.dtos.ReciboRequestDTO;
import com.pruebaTFG.myapp.exceptions.NivelNotFoundException;
import com.pruebaTFG.myapp.exceptions.ReciboNotFoundException;
import com.pruebaTFG.myapp.services.impl.IReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recibos")
public class ReciboController {

    @Autowired
    private IReciboService service;

    @PostMapping
    public ResponseEntity<ReciboDTO> create(@RequestBody ReciboDTO dto) {
        ReciboDTO reciboDTO = service.addRecibo(dto);
        return ResponseEntity.ok(reciboDTO);
    }

    @PostMapping("/generar")
    public ResponseEntity<List<ReciboDTO>> createRecibos(@RequestBody ReciboRequestDTO dto) {
        System.out.println("Los datos son: "+dto);
        List<ReciboDTO> recibosDTO = service.generarRecibos(dto.getFechaemision());
        return ResponseEntity.ok(recibosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReciboDTO> update(@PathVariable Long id, @RequestBody ReciboDTO dto) {
        ReciboDTO reciboDTO = service.editRecibo(id, dto);
        return ResponseEntity.ok(reciboDTO);
    }

    @GetMapping
    public ResponseEntity<List<ReciboDTO>> getAll() {
        List<ReciboDTO> lista = service.getAllRecibos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar")
    public ResponseEntity<ReciboDTO> getAll(@RequestParam String numerorecibo) {
        ReciboDTO reciboDTO = service.getRecibo(numerorecibo);
        return ResponseEntity.ok(reciboDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecibo(@PathVariable Long id) {
        service.eliminarRecibo(id);
        return ResponseEntity.noContent().build();
    }

    /* ================================================================================================================== */

    @ExceptionHandler(ReciboNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void recibosNotFound() {}

    @ExceptionHandler(NivelNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void nivelNotFound() {}

}
