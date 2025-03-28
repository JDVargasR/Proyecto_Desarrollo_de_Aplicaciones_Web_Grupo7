package com.Proyecto_Grupo7.service.impl;

import com.Proyecto_Grupo7.dao.PagoDao;
import com.Proyecto_Grupo7.domain.Pago;
import com.Proyecto_Grupo7.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoDao pagoDao;

    @Override
    public void guardar(Pago pago) {
        pagoDao.save(pago);
    }
}
