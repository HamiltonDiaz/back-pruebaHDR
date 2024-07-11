package com.backend.backend.contoller;

import com.backend.backend.application.cliente.dto.RespuestaClienteDTO;
import com.backend.backend.application.cliente.service.IClienteService;
import com.backend.backend.domain.cliente.Cliente;
import com.backend.backend.application.cliente.dto.ClienteDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @PostMapping
    public ResponseEntity <RespuestaClienteDTO> addCliente(@RequestBody @Valid ClienteDTO clienteDTO,
                                                           UriComponentsBuilder uriBuilder) {
        Cliente cliente = service.createCliente(clienteDTO);
        RespuestaClienteDTO respuestaClienteDTO = new RespuestaClienteDTO(cliente);
        URI url= uriBuilder.path("/api/v1/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaClienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaClienteDTO> getCliente(@PathVariable Long id) {
        Cliente cliente = service.getCliente(id);
        return ResponseEntity.ok(new RespuestaClienteDTO(cliente));
    }


}
