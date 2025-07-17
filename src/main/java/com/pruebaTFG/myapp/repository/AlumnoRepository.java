package com.pruebaTFG.myapp.repository;

import com.pruebaTFG.myapp.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {

    Optional<Alumno> findByDni(String dni);
    Optional<List<Alumno>> findByActivoTrueAndMensualidadTrue();

}
