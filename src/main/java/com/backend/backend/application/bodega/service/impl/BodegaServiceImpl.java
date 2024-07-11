package com.backend.backend.application.bodega.service.impl;

import com.backend.backend.application.bodega.mapper.BodegaMapper;
import com.backend.backend.application.bodega.service.IBodegaService;
import com.backend.backend.application.bodega.dto.BodegaDTO;
import com.backend.backend.domain.bodega.Bodega;
import com.backend.backend.domain.bodega.BodegaRepository;
import com.backend.backend.domain.contans.MessageApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class BodegaServiceImpl implements IBodegaService {
    @Autowired
    private BodegaRepository bodegaRepository;


    @Override
    public Bodega createBodega(BodegaDTO bodegaDTO) {
        if(!validaBodegaPorNombre(bodegaDTO.nombre())){
            Bodega saveBodega = BodegaMapper.toBodega(bodegaDTO);
            saveBodega.setCapacidadDisponible(bodegaDTO.capacidadAlmacenamiento());
            saveBodega.setFechaDeCreacion(LocalDate.now());
            return bodegaRepository.save(saveBodega);
        }else {
            throw new RuntimeException(MessageApplication.DUPLICATE);
        }

    }

    @Override
    public Bodega getBodega(Long id) {
        if (bodegaRepository.findById(id).isPresent()) {
            return bodegaRepository.getReferenceById(id);
        }else {
            throw new RuntimeException(MessageApplication.NOTFOUND);
        }
    }

    public  boolean validaBodegaPorNombre(String nombre) {
        return bodegaRepository.findByNombre(nombre).isPresent();
    }


}
