package com.example.demo.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Contacto;
import com.example.demo.service.EmailService;

import java.io.File;
import java.io.IOException;
@Controller
public class ContactoController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto(null, null, null, null));
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarCorreo(@ModelAttribute Contacto contacto,
                               @RequestParam("archivo") MultipartFile archivo,
                               Model model) throws IOException {

        File archivoFisico = null;
        if (!archivo.isEmpty()) {
            archivoFisico = File.createTempFile("upload-", archivo.getOriginalFilename());
            archivo.transferTo(archivoFisico);
        }

        try {
            emailService.enviarEmail(contacto, archivoFisico);
            model.addAttribute("mensaje", "Correo enviado correctamente.");
        } catch (MessagingException e) {
            model.addAttribute("mensaje", "Error al enviar el correo: " + e.getMessage());
        }

        return "contacto";
    }
}
