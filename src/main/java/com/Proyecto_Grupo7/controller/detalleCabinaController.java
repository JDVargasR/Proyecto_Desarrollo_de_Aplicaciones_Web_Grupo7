
package com.Proyecto_Grupo7.controller;

import com.Proyecto_Grupo7.domain.Reserva;
import com.Proyecto_Grupo7.service.DetalleCabinaService;
import com.Proyecto_Grupo7.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class DetalleCabinaController {

    @Autowired
    private DetalleCabinaService detallecabinaService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/detallecabina")
    public String listado(Model model) {
        var lista = detallecabinaService.getDetalleCabina(false);
        model.addAttribute("detallecabina", lista);
        model.addAttribute("totalDetalleCabina", lista.size());
        return "/detallecabina";
    }

    @GetMapping("/detallecabina/{id}")
    public String mostrarCabina(@PathVariable("id") Long id, Model model) {
        var cabina = detallecabinaService.getDetalleCabinaById(id);

        model.addAttribute("cabina", cabina);
        return "detalleCabina";
    }


    @PostMapping("/guardar-reserva")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        reservaService.guardar(reserva);
        Long id = reserva.getIdReserva();
        return "redirect:/pago/" + id;
    }
    
    

}
