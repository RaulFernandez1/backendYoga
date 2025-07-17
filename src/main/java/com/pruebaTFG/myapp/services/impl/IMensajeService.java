package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.MensajeDTO;
import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Grupo;
import com.pruebaTFG.myapp.entities.Mensaje;
import com.pruebaTFG.myapp.exceptions.AlumnoNotFoundException;
import com.pruebaTFG.myapp.exceptions.MensajeNotFoundException;
import com.pruebaTFG.myapp.mappers.MensajeMapper;
import com.pruebaTFG.myapp.repository.AlumnoRepository;
import com.pruebaTFG.myapp.repository.MensajeRepository;
import com.pruebaTFG.myapp.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IMensajeService implements MensajeService {

    @Autowired
    private MensajeRepository repoMensaje;

    @Autowired
    private AlumnoRepository repoAlumno;

    @Override
    public List<MensajeDTO> getAllMensajesPorAlumno(Long alumno_id) {
        Optional<Alumno> alumnoBD = repoAlumno.findById(alumno_id);
        if(alumnoBD.isEmpty()) throw new AlumnoNotFoundException();

        Optional<List<Mensaje>> mensajes = repoMensaje.findByAlumno(alumnoBD.get());
        if(mensajes.isEmpty()) throw new MensajeNotFoundException();

        return mensajes.get().stream().map(MensajeMapper::toDTO).toList();
    }

    @Override
    public MensajeDTO addMensaje(MensajeDTO dto) {
        Mensaje mensaje = MensajeMapper.toEntity(dto, repoAlumno);

        return MensajeMapper.toDTO(repoMensaje.save(mensaje));
    }

    @Override
    public void deleteMensaje(Long id) {
        Mensaje mensaje = buscarPorId(id);
        if(mensaje == null) throw new MensajeNotFoundException();

        repoMensaje.deleteById(id);
    }

    /*=====================================================================================*/

    private Mensaje buscarPorId(Long id) {
        Optional<Mensaje> opc = repoMensaje.findById(id);
        if(opc.isEmpty()) return null;
        return opc.get();
    }

}
