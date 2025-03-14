/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.service.impl;

import com.Proyecto_Grupo7.dao.ImagenesDao;
import com.Proyecto_Grupo7.domain.Imagenes;
import com.Proyecto_Grupo7.service.ImagenesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author josed
 */

@Service
public class ImagenesServiceImpl implements ImagenesService{
    
    @Autowired
    private ImagenesDao imagenesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Imagenes> getImagenes(boolean activos) {
        var lista = imagenesDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Imagenes getImagen(Imagenes imagenes) {
        return imagenesDao.findById(imagenes.getIdImagen()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Imagenes imagenes) {
        imagenesDao.save(imagenes);
    }

    @Override
    @Transactional
    public void delete(Imagenes imagenes) {
        imagenesDao.delete(imagenes);
    }
}
