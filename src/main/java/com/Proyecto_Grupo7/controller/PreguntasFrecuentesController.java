package com.Proyecto_Grupo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto_Grupo7.service.PreguntasFrecuentesService;

/**
 *
 * @author josed
 */
@Controller
@RequestMapping("/templates")
public class PreguntasFrecuentesController {

    @Autowired
    private PreguntasFrecuentesService preguntasfrecuentesService;

    @GetMapping("/preguntasFrecuentes")
    public String listado(Model model) {
        var lista = preguntasfrecuentesService.getPreguntasFrecuentes(false);
        model.addAttribute("preguntasFrecuentes", lista);
        model.addAttribute("totalPreguntasFrecuentes", lista.size());
        return "PreguntasFrecuentes/preguntasFrecuentes";
    }
}
