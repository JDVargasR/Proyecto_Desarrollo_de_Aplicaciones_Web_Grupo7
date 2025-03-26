package com.Proyecto_Grupo7.service.impl;

import com.Proyecto_Grupo7.dao.HabitacionesDao;
import com.Proyecto_Grupo7.domain.Habitaciones;
import com.Proyecto_Grupo7.service.HabitacionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HabitacionesServiceImpl implements HabitacionesService{
    
    @Autowired
    private HabitacionesDao habitacionesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Habitaciones> getHabitaciones(boolean activos) {
        var lista = habitacionesDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Habitaciones getImagen(Habitaciones habitaciones) {
        return habitacionesDao.findById(habitaciones.getIdHabitacion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Habitaciones habitaciones) {
        habitacionesDao.save(habitaciones);
    }

    @Override
    @Transactional
    public void delete(Habitaciones habitaciones) {
        habitacionesDao.delete(habitaciones);
    }
}
