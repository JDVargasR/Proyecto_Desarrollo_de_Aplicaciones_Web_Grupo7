package com.Proyecto_Grupo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Proyecto_Grupo7.domain.PreguntasFrecuentes;
import com.Proyecto_Grupo7.service.PreguntasFrecuentesService;


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


    @PostMapping("/preguntasFrecuentes/enviar")
    @PreAuthorize("hasRole('USER')")
    public String enviarPregunta(@RequestParam("pregunta") String preguntaTexto) {
        PreguntasFrecuentes nueva = new PreguntasFrecuentes();
        nueva.setPregunta(preguntaTexto);
        nueva.setActivo(true);
        preguntasfrecuentesService.save(nueva);
        return "redirect:/templates/preguntasFrecuentes";
    }
    
    @PostMapping("/admin/pregunta/editar-inline")
    @PreAuthorize("hasRole('ADMIN')")
    public String editarInline(
        @RequestParam("idPregunta") Long id,
        @RequestParam("pregunta") String pregunta,
        @RequestParam(value = "respuesta", required = false) String respuesta) {
    
        PreguntasFrecuentes existente = preguntasfrecuentesService.getPreguntaPorId(id);
        if (existente != null) {
            existente.setPregunta(pregunta);
            existente.setRespuesta(respuesta);
            preguntasfrecuentesService.save(existente);
        }
    
        return "redirect:/templates/preguntasFrecuentes";
    }
    
    @GetMapping("/admin/pregunta/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminarPregunta(@PathVariable("id") Long id) {
        preguntasfrecuentesService.delete(id);
        return "redirect:/templates/preguntasFrecuentes";
    }
    
}
