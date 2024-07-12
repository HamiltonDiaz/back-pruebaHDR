package com.backend.backend.application.bodega.service;


import com.backend.backend.application.bodega.dto.ActualizaBodegaDTO;
import com.backend.backend.application.bodega.dto.BodegaDTO;
import com.backend.backend.domain.bodega.Bodega;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBodegaService {
    Bodega createBodega(BodegaDTO bodegaDTO);

    Bodega updateBodega(ActualizaBodegaDTO actualizaBodegaDTO);
    void delteBodega(Long id);

    Bodega getBodega(Long id);

    Page<Bodega> listBodega(Pageable paginacion);
}
