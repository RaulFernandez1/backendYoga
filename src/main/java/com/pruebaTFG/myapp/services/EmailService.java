package com.pruebaTFG.myapp.services;

import com.pruebaTFG.myapp.dtos.EmailMensajeRequest;
import com.pruebaTFG.myapp.dtos.EmailReciboRequest;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendEmail(String to, String subject, String body);
    void sendEmailMensaje(EmailMensajeRequest request);
    void sendEmailRecibo(EmailReciboRequest request);

}
