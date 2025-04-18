package com.Proyecto_Grupo7.controller;

import com.Proyecto_Grupo7.domain.Imagenes;
import com.Proyecto_Grupo7.service.ImagenesService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/imagenes") 
public class ImagenesController {

    @Autowired
    private ImagenesService imagenesService;

    @GetMapping("")
    public String listado(@RequestParam(name = "idEditar", required = false) Long idEditar, Model model) {
        var lista = imagenesService.getImagenes(true);
        if (lista == null) {
            lista = new ArrayList<>();
        }
        model.addAttribute("imagenes", lista);
        model.addAttribute("idEditar", idEditar); // 🔁 para identificar qué imagen se está editando
        return "Imagenes/imagenes";
    }
    

    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public String agregar(@RequestParam String descripcion, @RequestParam String rutaImagen) {
        Imagenes img = new Imagenes();
        img.setDescripcion(descripcion);
        img.setRutaImagen(rutaImagen);
        img.setActivo(true);
        imagenesService.save(img);
        return "redirect:/imagenes"; 
    }
    

    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminar(@PathVariable("id") Long id) {
        Imagenes img = new Imagenes();
        img.setIdImagen(id);
        imagenesService.delete(img);
        return "redirect:/imagenes"; // ✅
    }

    @GetMapping("/editar/{id}")
@PreAuthorize("hasRole('ADMIN')")
public String editar(@PathVariable("id") Long id, Model model) {
    Imagenes img = new Imagenes();
    img.setIdImagen(id);
    Imagenes imagen = imagenesService.getImagen(img);
    model.addAttribute("imagen", imagen);
    return "Imagenes/editar";
}

@PostMapping("/actualizar")
@PreAuthorize("hasRole('ADMIN')")
public String actualizar(@ModelAttribute Imagenes imagen) {
    imagen.setActivo(true); // Por si se pierde el valor
    imagenesService.save(imagen);
    return "redirect:/imagenes";
}


}
