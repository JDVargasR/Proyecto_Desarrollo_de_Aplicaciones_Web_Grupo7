/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto_Grupo7.service;

import com.Proyecto_Grupo7.domain.PreguntasFrecuentes;
import java.util.List;

/**
 *
 * @author josed
 */
public interface PreguntasFrecuentesService {
    public List<PreguntasFrecuentes> getPreguntasFrecuentes(boolean activos);
    public PreguntasFrecuentes getImagen(PreguntasFrecuentes preguntasfrecuentes);
    public void save(PreguntasFrecuentes preguntasfrecuentes);
    public void delete(PreguntasFrecuentes preguntasfrecuentes);

    public PreguntasFrecuentes getPreguntaPorId(Long id);
    public void delete(Long id);

}
