package com.Proyecto_Grupo7.controller;

import com.Proyecto_Grupo7.domain.Pago;
import com.Proyecto_Grupo7.domain.Reserva;
import com.Proyecto_Grupo7.service.PagoService;
import com.Proyecto_Grupo7.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "pago";
    }

    @PostMapping("/guardar-pago")
    public String guardarPago(@ModelAttribute Pago pago) {
        pagoService.guardar(pago);
        return "redirect:/confirmacion-pago";
    }
}
