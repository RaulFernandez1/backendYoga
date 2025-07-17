package com.pruebaTFG.myapp.repository;

import com.pruebaTFG.myapp.entities.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Long> {

    Optional<Grupo> findByNombregrupo(String nombregrupo);

}
