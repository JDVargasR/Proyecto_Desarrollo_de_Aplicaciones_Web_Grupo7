/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto_Grupo7.service.HabitacionesService;


@Controller
@RequestMapping("/templates")
public class HabitacionesController {
    
    @Autowired
    private HabitacionesService habitacionesService;
    
    @GetMapping("/habitaciones")
    public String listado(Model model) {
        var lista = habitacionesService.getHabitaciones(false);
        model.addAttribute("habitaciones", lista);
        model.addAttribute("totalHabitaciones", lista.size());
        return "Habitaciones/habitaciones";
    }
}
