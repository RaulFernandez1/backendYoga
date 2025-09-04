package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.ReciboDTO;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Grupo;
import com.pruebaTFG.myapp.entities.Nivel;
import com.pruebaTFG.myapp.entities.Recibo;
import com.pruebaTFG.myapp.exceptions.GrupoNotFoundException;
import com.pruebaTFG.myapp.exceptions.NivelNotFoundException;
import com.pruebaTFG.myapp.exceptions.ReciboNotFoundException;
import com.pruebaTFG.myapp.mappers.ReciboMapper;
import com.pruebaTFG.myapp.repository.AlumnoRepository;
import com.pruebaTFG.myapp.repository.NivelRepository;
import com.pruebaTFG.myapp.repository.ReciboRepository;
import com.pruebaTFG.myapp.services.ReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IReciboService implements ReciboService {

    @Autowired
    private ReciboRepository repoRecibo;

    @Autowired
    private AlumnoRepository repoAlumno;


    @Override
    public ReciboDTO addRecibo(ReciboDTO dto) {
        if(repoRecibo.findByNumerorecibo(dto.getNumerorecibo()).isPresent()) return null;
        Recibo recibo = ReciboMapper.toEntity(dto,repoAlumno);
        return ReciboMapper.toDTO(repoRecibo.save(recibo));
    }

    @Override
    public List<ReciboDTO> generarRecibos(LocalDate fecha) {
        List<Alumno> alumnos = buscarPorActivoYMensualidad();
        List<Recibo> recibos = new ArrayList<>();
        int anyo = fecha.getYear();
        int mes = fecha.getMonthValue();
        long contador =  Long.parseLong(repoRecibo.findUltimoNombreRecibo().split("-")[3]);

        for (Alumno a : alumnos) {
            contador++;

            Recibo recibo = Recibo.builder()
                    .alumno(a)
                    .fecharecibo(fecha)
                    .cantidad(a.getPrecio())
                    .pagado(false)
                    .numerorecibo(generarNumeroRecibo(anyo, mes, contador))
                    .build();
            repoRecibo.save(recibo);
            recibos.add(recibo);
        }

        return recibos.stream().map(ReciboMapper::toDTO).toList();
    }

    @Override
    public ReciboDTO editRecibo(Long id, ReciboDTO dto) {
        Recibo reciboBD = buscarPorId(id);
        if(reciboBD == null) throw new ReciboNotFoundException();

        dto.setId(id);
        Recibo recibo = repoRecibo.save(ReciboMapper.toEntity(dto,repoAlumno));

        return ReciboMapper.toDTO(recibo);
    }

    @Override
    public List<ReciboDTO> getAllRecibos() {
        List<Recibo> recibos = repoRecibo.findAll();
        return recibos.stream().map(ReciboMapper::toDTO).toList();
    }

    @Override
    public ReciboDTO getRecibo(String numerorecibo) {
        Optional<Recibo> reciboBD = repoRecibo.findByNumerorecibo(numerorecibo);
        if(reciboBD.isEmpty()) throw new ReciboNotFoundException();

        return ReciboMapper.toDTO(reciboBD.get());
    }

    @Override
    public void eliminarRecibo(Long id) {
        Recibo reciboBD = buscarPorId(id);
        if(reciboBD == null) throw new ReciboNotFoundException();

        repoRecibo.deleteById(id);
    }


    /*=====================================================================================*/

    private Recibo buscarPorId(Long id) {
        Optional<Recibo> opc = repoRecibo.findById(id);
        if(opc.isEmpty()) return null;
        return opc.get();
    }

    private List<Alumno> buscarPorActivoYMensualidad() {
        Optional<List<Alumno>> opc = repoAlumno.findByActivoTrueAndMensualidadTrue();
        if(opc.isEmpty()) return null;
        return opc.get();
    }

    private String generarNumeroRecibo(int anyo, int mes, long contador) {
        return String.format("REC-%d-%02d-%04d", anyo, mes, contador);
    }

}
