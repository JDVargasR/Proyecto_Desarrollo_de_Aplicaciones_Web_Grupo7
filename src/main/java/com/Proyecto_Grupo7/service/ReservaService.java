package com.Proyecto_Grupo7.service;

import com.Proyecto_Grupo7.domain.Reserva;
import java.util.List;

public interface ReservaService {

    public void guardar(Reserva reserva);

    public List<Reserva> listarReservas();
    
    public Reserva encontrarPorId(Long id);
}
