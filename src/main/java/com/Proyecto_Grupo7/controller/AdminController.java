package com.Proyecto_Grupo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Proyecto_Grupo7.service.ContactoService;



@Controller
public class AdminController {

    @Autowired
    private ContactoService contactoService;
    
@GetMapping("/admin/panel")
@PreAuthorize("hasRole('ADMIN')")
public String mostrarPanelAdmin() {
    return "PanelAdmin/panelAdmin";
}
@GetMapping("/admin/contactos")
@PreAuthorize("hasRole('ADMIN')")
public String verMensajesContacto(Model model) {
    model.addAttribute("listaMensajes", contactoService.obtenerContactos(true));
    return "PanelAdmin/contactos";
}

}
