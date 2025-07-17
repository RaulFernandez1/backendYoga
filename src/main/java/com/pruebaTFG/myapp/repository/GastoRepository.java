package com.pruebaTFG.myapp.repository;

import com.pruebaTFG.myapp.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface GastoRepository extends JpaRepository<Gasto,Long> {

    Optional<Gasto> findByFechagastoAndDescripcionAndCantidadgasto(LocalDate fechagasto, String descripcion, Float cantidadgasto);

}
