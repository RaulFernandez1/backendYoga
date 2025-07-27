package com.pruebaTFG.myapp.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequestDTO {

    private String to;
    private String subject;
    private String body;

}
