package com.example.demo.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contacto;

import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(Contacto contacto, File archivo) throws MessagingException {
        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

        helper.setTo(contacto.getCorreo());
        helper.setSubject(contacto.getAsunto());
        helper.setFrom(contacto.getCorreo());

        String html = "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 20px; color: #333333; }"
                + "  h3 { color: #4CAF50; }"
                + "  .content { background-color: #ffffff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }"
                + "  p { font-size: 16px; line-height: 1.6; margin: 10px 0; }"
                + "  .info { font-weight: bold; color: #333333; }"
                + "  .footer { font-size: 14px; color: #777777; margin-top: 20px; text-align: center; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='content'>"
                + "<h3>¡Tienes un nuevo mensaje!</h3>"
                + "<p><span class='info'>Nombre:</span> " + contacto.getNombre() + "</p>"
                + "<p><span class='info'>Correo:</span> " + contacto.getCorreo() + "</p>"
                + "<p><span class='info'>Asunto:</span> " + contacto.getAsunto() + "</p>"
                + "<p><span class='info'>Mensaje:</span> " + contacto.getMensaje() + "</p>"
                + "</div>"
                + "<div class='footer'>"
                + "<p>Este es un correo automático, por favor no respondas.</p>"
                + "</div>"
                + "</body>"
                + "</html>";

        helper.setText(html, true); // Habilitar interpretación de HTML

        if (archivo != null) {
            FileSystemResource file = new FileSystemResource(archivo);
            helper.addAttachment(file.getFilename(), file);
        }

        mailSender.send(mensaje);
    }
}