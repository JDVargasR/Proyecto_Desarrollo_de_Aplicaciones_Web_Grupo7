package com.Proyecto_Grupo7.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto_Grupo7.dao.EnergiaRenovableDao;
import com.Proyecto_Grupo7.domain.EnergiaRenovable;
import com.Proyecto_Grupo7.service.EnergiaRenovableService;

@Service
public class EnergiaRenovableServiceImpl implements EnergiaRenovableService {

    @Autowired
    private EnergiaRenovableDao dao;

    @Override
    public List<EnergiaRenovable> listarEnergias() {
       return dao.findAll();
    }

    @Override
    public void guardar(EnergiaRenovable energia) {
        dao.save(energia);
    }

    @Override
    public void eliminar(EnergiaRenovable energia) {
        dao.delete(energia);
    }

    @Override
    public EnergiaRenovable encontrarPorId(Long id) {
        return dao.findById(id).orElse(null);
    }
    
}
