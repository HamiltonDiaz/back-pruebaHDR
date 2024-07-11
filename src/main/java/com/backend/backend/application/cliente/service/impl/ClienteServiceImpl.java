package com.backend.backend.application.cliente.service.impl;

import com.backend.backend.application.cliente.mapper.ClienteMapper;
import com.backend.backend.application.cliente.service.IClienteService;
import com.backend.backend.domain.cliente.Cliente;
import com.backend.backend.application.cliente.dto.ClienteDTO;
import com.backend.backend.domain.cliente.ClienteRepository;
import com.backend.backend.domain.contans.MessageApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Cliente createCliente(ClienteDTO clienteDTO) {
        if(Boolean.FALSE.equals(validaClienteDocumentoTipoIdentfificacion(clienteDTO))){
            Cliente saveCliente = ClienteMapper.toCliente(clienteDTO);
            saveCliente.setActivo(true);
            saveCliente.setFechaDeCreacion(LocalDate.now());
            return clienteRepository.save(saveCliente);
        }else {
            throw new RuntimeException(MessageApplication.DUPLICATE);
        }

    }

    @Override
    public Cliente getCliente(Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            return clienteRepository.getReferenceById(id);
        }else {
            throw new RuntimeException(MessageApplication.NOTFOUND);
        }
    }

    public  boolean validaClienteDocumentoTipoIdentfificacion(ClienteDTO clienteDTO) {
        Optional<Cliente> cliente= clienteRepository.findByTipoDocumentoAndDocumento(clienteDTO.tipoDocumento(),clienteDTO.documento());
        if(cliente.isPresent()){
            return true;
        }
        return false;
    }


}
