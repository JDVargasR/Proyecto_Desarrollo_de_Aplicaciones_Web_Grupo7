package com.Proyecto_Grupo7.service.impl;

import com.Proyecto_Grupo7.dao.DetalleCabinaDao;
import com.Proyecto_Grupo7.domain.DetalleCabina;
import com.Proyecto_Grupo7.service.DetalleCabinaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatalleCabinaServiceImpl implements DetalleCabinaService {

    @Autowired
    private DetalleCabinaDao detallecabinaDao;

    @Override
    @Transactional(readOnly = true)
    public List<DetalleCabina> getDetalleCabina(boolean activos) {
        var lista = detallecabinaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleCabina getImagen(DetalleCabina detallecabina) {
        return detallecabinaDao.findById(detallecabina.getIdDetalleCabina()).orElse(null);
    }

    @Override
    @Transactional
    public void save(DetalleCabina detallecabina) {
        detallecabinaDao.save(detallecabina);
    }

    @Override
    @Transactional
    public void delete(DetalleCabina detallecabina) {
        detallecabinaDao.delete(detallecabina);
    }

    @Override
    public DetalleCabina getDetalleCabinaById(Long id) {
        return detallecabinaDao.findById(id).orElse(null);
    }
}
