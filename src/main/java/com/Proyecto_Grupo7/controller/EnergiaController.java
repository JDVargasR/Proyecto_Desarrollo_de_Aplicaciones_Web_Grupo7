package com.Proyecto_Grupo7.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Proyecto_Grupo7.domain.EnergiaRenovable;
import com.Proyecto_Grupo7.service.EnergiaRenovableService;


@Controller
@RequestMapping("/energias") // 
public class EnergiaController {
    
    @Autowired
    private EnergiaRenovableService energiaService;
   @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("energias", energiaService.listarEnergias());
        return "EnergiasRenovables/EnergiasRenovables";
    }


@PostMapping("/guardar")
public String guardar(
        @ModelAttribute EnergiaRenovable energia,
        @RequestParam("imagenFile") MultipartFile imagenFile
) {
    try {
        if (!imagenFile.isEmpty()) {
            // Generar un nombre único
            String nombreArchivo = UUID.randomUUID() + "_" + imagenFile.getOriginalFilename();
            
            // Ruta relativa al directorio static/uploads
            String rutaRelativa = "/Img's/ImagenesEnergiasRenovables/"  + nombreArchivo;
            Path rutaAbsoluta = Paths.get("src/main/resources/static" + rutaRelativa);
            
            // Crear carpetas si no existen
            Files.createDirectories(rutaAbsoluta.getParent());

            // Guardar el archivo
            Files.copy(imagenFile.getInputStream(), rutaAbsoluta, StandardCopyOption.REPLACE_EXISTING);

            // Guardar la ruta en la entidad
            energia.setImagenUrl(rutaRelativa);
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Podés redirigir a una página de error si querés
        return "redirect:/energias/lista?errorImagen";
    }

    energiaService.guardar(energia);
    return "redirect:/energias/lista";
}

@PostMapping("/editar/{id}")
public String actualizar(
        @PathVariable("id") Long id,
        @ModelAttribute EnergiaRenovable energia,
        @RequestParam("imagenFile") MultipartFile imagenFile
) {
    try {
        if (!imagenFile.isEmpty()) {
            String nombreArchivo = UUID.randomUUID() + "_" + imagenFile.getOriginalFilename();
            String rutaRelativa = "/Img's/ImagenesEnergiasRenovables/" + nombreArchivo;
            Path rutaAbsoluta = Paths.get("src/main/resources/static" + rutaRelativa);
            Files.createDirectories(rutaAbsoluta.getParent());
            Files.copy(imagenFile.getInputStream(), rutaAbsoluta, StandardCopyOption.REPLACE_EXISTING);
            energia.setImagenUrl(rutaRelativa);
        } else {
            // Mantené la imagen original si no se subió una nueva
            EnergiaRenovable original = energiaService.encontrarPorId(id);
            energia.setImagenUrl(original.getImagenUrl());
        }
    } catch (IOException e) {
        e.printStackTrace();
        return "redirect:/energias/lista?errorImagen";
    }

    energia.setId_energias_renovables(id);
    energiaService.guardar(energia);
    return "redirect:/energias/lista";
}

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        EnergiaRenovable energia = energiaService.encontrarPorId(id);
        energiaService.eliminar(energia);
        return "redirect:/energias/lista";
    }



}
