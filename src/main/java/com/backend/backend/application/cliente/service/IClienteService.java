package com.backend.backend.application.cliente.service;


import com.backend.backend.domain.cliente.Cliente;
import com.backend.backend.application.cliente.dto.ClienteDTO;


public interface IClienteService {
    Cliente createCliente(ClienteDTO clienteDTO);

    Cliente getCliente(Long id);
}
