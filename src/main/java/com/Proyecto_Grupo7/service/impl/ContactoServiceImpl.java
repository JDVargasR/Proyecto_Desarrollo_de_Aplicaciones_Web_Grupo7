/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto_Grupo7.dao.ContactoDao;
import com.Proyecto_Grupo7.domain.Contacto;
import com.Proyecto_Grupo7.service.ContactoService;

/**
 *
 * @author josed
 */

@Service
public class ContactoServiceImpl implements ContactoService{
    
    @Autowired
    private ContactoDao contactoDao;
    
    @Override
    public List<Contacto> obtenerContactos() {
        return contactoDao.findAll();
    }

    @Override
    public Contacto guardarContacto(Contacto contacto) {
        contacto.setActivo(true);  
        return contactoDao.save(contacto);
    }

    @Override
    public void eliminarContacto(long  id) {
        contactoDao.deleteById(id);
    }


        @Override
    @Transactional(readOnly = true)
    public List<Contacto> obtenerContactos(boolean activos) {
        var lista = contactoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

        @Override
        @Transactional(readOnly = true)
        public Contacto obtenerContactos(Contacto contacto) {
            return contactoDao.findById(contacto.getIdContacto()).orElse(null);
        }
}
