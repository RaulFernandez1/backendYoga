package com.pruebaTFG.myapp.repository;

import com.pruebaTFG.myapp.entities.Alumno;
import com.pruebaTFG.myapp.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    Optional<List<Mensaje>> findByAlumno(Alumno alumno);

}
