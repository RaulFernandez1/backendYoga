package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.GastoDTO;
import com.pruebaTFG.myapp.dtos.NivelDTO;
import com.pruebaTFG.myapp.exceptions.GastoNotFoundException;
import com.pruebaTFG.myapp.exceptions.NivelBadRequestException;
import com.pruebaTFG.myapp.exceptions.NivelNotFoundException;
import com.pruebaTFG.myapp.services.impl.IGastoService;
import com.pruebaTFG.myapp.services.impl.INivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private IGastoService service;

    @PostMapping
    public ResponseEntity<GastoDTO> aniadirGastos(@RequestBody GastoDTO gasto) {
        GastoDTO gt = service.addGastos(gasto);
        return ResponseEntity.ok(gt);
    }

    @GetMapping
    public ResponseEntity<List<GastoDTO>> obtenerTodosGastos() {
        List<GastoDTO> lista = service.getAllGastos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar")
    public ResponseEntity<GastoDTO> obtenerGasto(@RequestParam("fechagasto") LocalDate fechagasto,
                                                       @RequestParam("descripcion") String descripcion,
                                                       @RequestParam("cantidadgasto") Float cantidadgasto) {
        GastoDTO dto = service.getGasto(fechagasto,descripcion,cantidadgasto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGastos(@PathVariable(name = "id") Long gastoId) {
        service.deleteGastoById(gastoId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarGastos(@RequestParam("fechagasto") LocalDate fechagasto,
                                               @RequestParam("descripcion") String descripcion,
                                               @RequestParam("cantidadgasto") Float cantidadgasto) {
        service.deleteGastoByPK(fechagasto,descripcion,cantidadgasto);
        return ResponseEntity.noContent().build();
    }

    /*================================================================================================================*/



    /*================================================================================================================*/

    @ExceptionHandler(GastoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void gastoNoEncontrado() {}

}
