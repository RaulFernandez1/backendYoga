package com.pruebaTFG.myapp.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ReciboRequestDTO {
    private LocalDate fechaemision;
}
