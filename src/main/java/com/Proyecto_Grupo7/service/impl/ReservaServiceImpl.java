package com.Proyecto_Grupo7.service.impl;

import com.Proyecto_Grupo7.dao.ReservaDao;
import com.Proyecto_Grupo7.domain.Reserva;
import com.Proyecto_Grupo7.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaDao reservaDao;

    @Override
    public void guardar(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    public List<Reserva> listarReservas() {
        return (List<Reserva>) reservaDao.findAll();
    }

    @Override
    public Reserva encontrarPorId(Long id) {
        return reservaDao.findById(id).orElse(null);
    }
}
