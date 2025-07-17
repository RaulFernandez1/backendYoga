package com.pruebaTFG.myapp.repository;

import com.pruebaTFG.myapp.entities.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Long> {

    Optional<Recibo> findByNumerorecibo(String numerorecibo);

    @Query("SELECT COUNT(r) FROM Recibo r WHERE YEAR(r.fecharecibo) = :año AND MONTH(r.fecharecibo) = :mes")
    long countByYearAndMonth(@Param("año") int año, @Param("mes") int mes);

    @Query(value = "SELECT numerorecibo FROM recibos ORDER BY numerorecibo DESC LIMIT 1", nativeQuery = true)
    String findUltimoNombreRecibo();


}
