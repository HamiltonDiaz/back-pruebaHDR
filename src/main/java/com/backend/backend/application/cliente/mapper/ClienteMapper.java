package com.backend.backend.application.cliente.mapper;

import com.backend.backend.application.cliente.dto.ClienteDTO;
import com.backend.backend.domain.cliente.Cliente;

public class ClienteMapper {
    public static Cliente toCliente(ClienteDTO clienteDTO) {
        return Cliente.builder()
                .nombre(clienteDTO.nombre())
                .email(clienteDTO.email())
                .tipoDocumento(clienteDTO.tipoDocumento())
                .documento(clienteDTO.documento())
                .direccion(clienteDTO.direccion())
                .build();
    }
}
