package com.backend.backend.application.cliente.dto;

import com.backend.backend.domain.cliente.Cliente;
import com.backend.backend.domain.cliente.TipoDocumento;


public record RespuestaClienteDTO(
        Long id ,
        String nombre,
        String email,
        String tipoDocumento,
        String documento,
        String direccion
) {
    public RespuestaClienteDTO(Cliente cliente) {
        this(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getEmail(),
            cliente.getTipoDocumento().name(),
            cliente.getDocumento(),
            cliente.getDireccion()
        );
    }
}
