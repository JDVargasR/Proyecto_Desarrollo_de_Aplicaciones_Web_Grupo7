/*
 * controlador pr josue 
 */
package com.Proyecto_Grupo7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto_Grupo7.domain.Contacto;
import com.Proyecto_Grupo7.service.ContactoService;


@Controller
@RequestMapping("/templates/contacto")
public class ContactoController {
    
    @Autowired
    private ContactoService contactoService;

    @GetMapping()
    public String listarContactos(Model model) {
        List<Contacto> contactos = contactoService.obtenerContactos();
        model.addAttribute("contactos", contactos);
        return "Contacto/contacto";
    }

    @PostMapping("/guardar")
    public String guardarMensaje(Contacto contacto, Model model) {
        contactoService.guardarContacto(contacto);
        model.addAttribute("mensajeExito", "✅ ¡Mensaje enviado correctamente! Te contactaremos pronto.");
        return "Contacto/contacto"; // Redirige a la misma vista
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable Integer id) {
        contactoService.eliminarContacto(id);
        return "redirect:/templates/contacto";
    }
}
