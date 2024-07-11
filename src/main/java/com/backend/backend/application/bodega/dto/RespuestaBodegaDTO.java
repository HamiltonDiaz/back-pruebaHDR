package com.backend.backend.application.bodega.dto;

import com.backend.backend.domain.bodega.Bodega;

import java.math.BigDecimal;


public record RespuestaBodegaDTO(
        Long id,
        String nombre,
        String direccion,
        String ciudad,
        String pais,
        String codigoPostal,
        BigDecimal capacidadAlmacenamiento,
        BigDecimal capacidadDisponible,
        String responsable,
        String telefonoContacto,
        String emailContacto,
        String tipoBodega
) {
    public RespuestaBodegaDTO(Bodega bodega) {
        this(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getDireccion(),
                bodega.getCiudad(),
                bodega.getPais(),
                bodega.getCodigoPostal(),
                bodega.getCapacidadAlmacenamiento(),
                bodega.getCapacidadDisponible(),
                bodega.getResponsable(),
                bodega.getTelefonoContacto(),
                bodega.getEmailContacto(),
                bodega.getTipoBodega().name()
        );
    }
}
