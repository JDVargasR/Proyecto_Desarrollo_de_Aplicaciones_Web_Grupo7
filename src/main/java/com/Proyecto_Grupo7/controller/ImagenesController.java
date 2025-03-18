/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.controller;

import com.Proyecto_Grupo7.service.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/templates")
public class ImagenesController {
    
    @Autowired
    private ImagenesService imagenesService;
    
    @GetMapping("/imagenes")
    public String listado(Model model) {
        var lista = imagenesService.getImagenes(false);
        model.addAttribute("imagenes", lista);
        model.addAttribute("totalImagenes", lista.size());
        return "/imagenes";
    }
}
