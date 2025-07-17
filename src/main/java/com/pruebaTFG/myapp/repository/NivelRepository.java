package com.pruebaTFG.myapp.repository;

import com.pruebaTFG.myapp.entities.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {

    Optional<Nivel> findByNombrenivelAndCondicion(String nombrenivel, String condicion);

}
