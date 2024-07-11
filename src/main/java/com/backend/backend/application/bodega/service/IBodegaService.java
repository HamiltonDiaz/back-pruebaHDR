package com.backend.backend.application.bodega.service;


import com.backend.backend.application.bodega.dto.BodegaDTO;
import com.backend.backend.domain.bodega.Bodega;


public interface IBodegaService {
    Bodega createBodega(BodegaDTO bodegaDTO);

    Bodega getBodega(Long id);
}
