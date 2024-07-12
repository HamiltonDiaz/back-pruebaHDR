package com.backend.backend.application.bodega.dto;

import com.backend.backend.domain.bodega.Bodega;

import java.math.BigDecimal;


public record RespuestaBodegaPedidoDTO(
        Long id,
        String nombre,
        String direccion,
        String ciudad,
        String estado,
        String pais,
        String codigoPostal,

        String tipoBodega
) {
    public RespuestaBodegaPedidoDTO(Bodega bodega) {
        this(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getDireccion(),
                bodega.getCiudad(),
                bodega.getEstado(),
                bodega.getPais(),
                bodega.getCodigoPostal(),
                bodega.getTipoBodega().name()
        );
    }
}
