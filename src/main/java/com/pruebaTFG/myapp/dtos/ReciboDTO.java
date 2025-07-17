package com.pruebaTFG.myapp.dtos;

import com.pruebaTFG.myapp.entities.Alumno;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ReciboDTO {

    private Long id;

    private String numerorecibo;

    private Boolean pagado;
    private Float cantidad;
    private LocalDate fecharecibo;

    private Long alumno;

}
