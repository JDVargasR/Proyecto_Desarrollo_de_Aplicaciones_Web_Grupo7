package com.Proyecto_Grupo7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Proyecto_Grupo7.domain.Pago;
import com.Proyecto_Grupo7.domain.Reserva;
import com.Proyecto_Grupo7.service.PagoService;
import com.Proyecto_Grupo7.service.ReservaService;

@Controller
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/pago/{id}")
    public String mostrarFormularioPago(@PathVariable("id") Long idReserva, Model model) {
        Reserva reserva = reservaService.encontrarPorId(idReserva);
        Pago pago = new Pago();
        pago.setReserva(reserva);
    
        model.addAttribute("pago", pago);
        model.addAttribute("cabina", reserva.getCabina());
    
        // ✅ Calculamos el monto total: precio * cantidad de personas
        double total = reserva.getCabina().getPrecio() * reserva.getPersonas();
        model.addAttribute("total", total);
    
        return "pago";
    }
    
    

    @PostMapping("/guardar-pago")
    public String guardarPago(@ModelAttribute Pago pago) {
        pagoService.guardar(pago);
        return "redirect:/confirmacion-pago";
    }
}
