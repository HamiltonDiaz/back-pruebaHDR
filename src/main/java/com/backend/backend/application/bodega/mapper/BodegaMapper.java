package com.backend.backend.application.bodega.mapper;

import com.backend.backend.application.bodega.dto.BodegaDTO;
import com.backend.backend.domain.bodega.Bodega;


public class BodegaMapper {
    public static Bodega toBodega(BodegaDTO bodegaDTO) {
        Bodega bodega = Bodega.builder()
                .nombre(bodegaDTO.nombre())
                .direccion(bodegaDTO.direccion())
                .ciudad(bodegaDTO.ciudad())
                .estado(bodegaDTO.estado())
                .pais(bodegaDTO.pais())
                .codigoPostal(bodegaDTO.codigoPostal())
                .capacidadAlmacenamiento(bodegaDTO.capacidadAlmacenamiento())
                .tipoBodega(bodegaDTO.tipoBodega())
                .build();
        return bodega;
    }
}
