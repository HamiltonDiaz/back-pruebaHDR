package com.backend.backend.application.bodega.service.impl;

import com.backend.backend.application.bodega.dto.ActualizaBodegaDTO;
import com.backend.backend.application.bodega.mapper.BodegaMapper;
import com.backend.backend.application.bodega.service.IBodegaService;
import com.backend.backend.application.bodega.dto.BodegaDTO;
import com.backend.backend.domain.bodega.Bodega;
import com.backend.backend.domain.bodega.BodegaRepository;
import com.backend.backend.domain.contans.MessageApplication;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Transactional
    public Bodega updateBodega(ActualizaBodegaDTO actualizaBodegaDTO) {
        if (bodegaRepository.findById(actualizaBodegaDTO.id()).isPresent()) {
            Bodega updateBodega= bodegaRepository.getReferenceById(actualizaBodegaDTO.id());
            updateBodega.setNombre(actualizaBodegaDTO.nombre());
            updateBodega.setDireccion(actualizaBodegaDTO.direccion());
            updateBodega.setCiudad(actualizaBodegaDTO.ciudad());
            updateBodega.setEstado(actualizaBodegaDTO.estado());
            updateBodega.setPais(actualizaBodegaDTO.pais());
            updateBodega.setCodigoPostal(actualizaBodegaDTO.codigoPostal());
            updateBodega.setCapacidadAlmacenamiento(actualizaBodegaDTO.capacidadAlmacenamiento());
            updateBodega.setCapacidadDisponible(actualizaBodegaDTO.capacidadDisponible());
            updateBodega.setResponsable(actualizaBodegaDTO.responsable());
            updateBodega.setTelefonoContacto(actualizaBodegaDTO.telefonoContacto());
            updateBodega.setEmailContacto(actualizaBodegaDTO.emailContacto());
            updateBodega.setTipoBodega(actualizaBodegaDTO.tipoBodega());
            updateBodega.setFechaDeModificacion(LocalDate.now());
            return updateBodega;

        }else {
            throw new RuntimeException(MessageApplication.NOTFOUND);
        }
    }

    @Override
    public void delteBodega(Long id) {
        if (bodegaRepository.findById(id).isPresent()) {
            bodegaRepository.delete(bodegaRepository.getReferenceById(id));
        }else {
            throw new RuntimeException(MessageApplication.NOTFOUND);
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

    @Override
    public Page<Bodega> listBodega(Pageable paginacion) {
        return bodegaRepository.findAll(paginacion);
    }

    public  boolean validaBodegaPorNombre(String nombre) {
        return bodegaRepository.findByNombre(nombre).isPresent();
    }


}
