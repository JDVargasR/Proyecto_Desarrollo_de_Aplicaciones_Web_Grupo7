package com.Proyecto_Grupo7.service;

import java.util.List;

import com.Proyecto_Grupo7.domain.EnergiaRenovable;


public interface EnergiaRenovableService {
    List<EnergiaRenovable> listarEnergias();
    void guardar(EnergiaRenovable energia);
    void eliminar(EnergiaRenovable energia);
    EnergiaRenovable encontrarPorId(Long id);
}
