package com.pruebaTFG.myapp.services.impl;

import com.pruebaTFG.myapp.dtos.EmailMensajeRequest;
import com.pruebaTFG.myapp.dtos.EmailReciboRequest;
import com.pruebaTFG.myapp.exceptions.EmailServerInternalException;
import com.pruebaTFG.myapp.services.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class IEmailService implements EmailService {

    @Value("spring.mail.username")
    private String username;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setFrom(username);
        mensaje.setTo(to);
        mensaje.setSubject(subject);
        mensaje.setText(body);

        mailSender.send(mensaje);
    }

    @Override
    public void sendEmailMensaje(EmailMensajeRequest request) {
        Context contexto = new Context();

        contexto.setVariable("letra",request.getLetra());
        contexto.setVariable("nombre",request.getNombre());
        contexto.setVariable("rol",request.getRol());
        contexto.setVariable("asunto",request.getAsunto());
        contexto.setVariable("contenido",request.getContenido());
        contexto.setVariable("fecha",request.getFechaHora().format(DateTimeFormatter.ISO_LOCAL_DATE));
        contexto.setVariable("hora",request.getFechaHora().format(DateTimeFormatter.ISO_LOCAL_TIME));

        contexto.setVariable("importante",request.isImportante());
        contexto.setVariable("leido",request.isLeido());
        contexto.setVariable("grupo",request.isGrupo());

        LocalDateTime fecha = request.getFechaHora();
        System.out.println("HOAAAAAA ==> "+fecha.toString());
        System.out.println("HOAAAAAA ==> "+fecha.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("HOAAAAAA ==> "+fecha.format(DateTimeFormatter.ISO_LOCAL_TIME));

        String html = this.renderHTMLTemplate(contexto,"email-mensaje");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());
            helper.setText(html,true);
            helper.addInline("logoSadhana", new ClassPathResource("static/assets/logo.png"));

            mailSender.send(message);
        }
        catch (Exception e) {
            throw new EmailServerInternalException();
        }
    }

    @Override
    public void sendEmailRecibo(EmailReciboRequest request) {
        Context contexto = new Context();

        contexto.setVariable("nombre", request.getNombre());
        contexto.setVariable("apellido1", request.getApellido1());
        contexto.setVariable("apellido2", request.getApellido2());
        contexto.setVariable("fecha", request.getFecha().format(DateTimeFormatter.ISO_LOCAL_DATE));
        contexto.setVariable("importe", request.getImporte());
        contexto.setVariable("nivel", request.getNivel());

        String html = renderHTMLTemplate(contexto,"email-recibo");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());
            helper.setText(html,true);
            helper.addInline("logoSadhana", new ClassPathResource("static/assets/logo.png"));
            helper.addInline("soloLogo", new ClassPathResource("static/assets/soloLogo.png"));

            mailSender.send(message);
        }
        catch (Exception e) {
            throw new EmailServerInternalException();
        }
    }


    /* ============================================================================================================== */

    private String renderHTMLTemplate(Context contexto, String nombrePlantilla) {
        return templateEngine.process(nombrePlantilla,contexto);
    }

}
