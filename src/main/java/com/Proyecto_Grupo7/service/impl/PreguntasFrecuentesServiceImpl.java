/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.service.impl;

import com.Proyecto_Grupo7.dao.PreguntasFrecuentesDao;
import com.Proyecto_Grupo7.domain.PreguntasFrecuentes;
import com.Proyecto_Grupo7.service.PreguntasFrecuentesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josed
 */

@Service
public class PreguntasFrecuentesServiceImpl implements PreguntasFrecuentesService{
    
    @Autowired
    private PreguntasFrecuentesDao preguntasfrecuentesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<PreguntasFrecuentes> getPreguntasFrecuentes(boolean activos) {
        var lista = preguntasfrecuentesDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public PreguntasFrecuentes getImagen(PreguntasFrecuentes preguntasfrecuentes) {
        return preguntasfrecuentesDao.findById(preguntasfrecuentes.getIdPregunta()).orElse(null);
    }

    @Override
    @Transactional
    public void save(PreguntasFrecuentes preguntasfrecuentes) {
        preguntasfrecuentesDao.save(preguntasfrecuentes);
    }

    @Override
    @Transactional
    public void delete(PreguntasFrecuentes preguntasfrecuentes) {
        preguntasfrecuentesDao.delete(preguntasfrecuentes);
    }
}
