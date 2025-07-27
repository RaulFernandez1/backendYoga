package com.pruebaTFG.myapp.controllers;

import com.pruebaTFG.myapp.dtos.EmailMensajeRequest;
import com.pruebaTFG.myapp.dtos.EmailReciboRequest;
import com.pruebaTFG.myapp.dtos.EmailRequestDTO;
import com.pruebaTFG.myapp.exceptions.EmailServerInternalException;
import com.pruebaTFG.myapp.services.impl.IEmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private IEmailService service;

    @PostMapping("/send")
    private ResponseEntity<?> enviarEmail(@RequestBody EmailRequestDTO dto) {
        service.sendEmail(dto.getTo(), dto.getSubject(), dto.getBody());
        return ResponseEntity.ok("Correo enviado");
    }

    @PostMapping("/send/mensaje")
    private ResponseEntity<Void> enviarEmailMensaje(@RequestBody EmailMensajeRequest request) {
        service.sendEmailMensaje(request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send/recibo")
    private ResponseEntity<Void> enviarEmailRecibo(@RequestBody EmailReciboRequest request) {
        service.sendEmailRecibo(request);
        return ResponseEntity.noContent().build();
    }


    /* ============================================================================================================== */

    @ExceptionHandler(EmailServerInternalException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error al enviar el mensaje por correo")
    public void errorConEnvioDeMensaje() {}

}
