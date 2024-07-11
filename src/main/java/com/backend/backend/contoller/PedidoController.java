package com.backend.backend.contoller;

import com.backend.backend.application.pedido.dto.PedidoDTO;
import com.backend.backend.application.pedido.dto.RespuestaPedidoDTO;
import com.backend.backend.application.pedido.service.IPedidoService;
import com.backend.backend.domain.pedido.Pedido;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PostMapping
    public ResponseEntity <RespuestaPedidoDTO> addPedido(@RequestBody @Valid PedidoDTO pedidoDTO,
                                                         UriComponentsBuilder uriBuilder) {
        Pedido pedido = service.createPedido(pedidoDTO);
        RespuestaPedidoDTO respuestaPedidoDTO = new RespuestaPedidoDTO(pedido);
        URI url= uriBuilder.path("/api/v1/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaPedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaPedidoDTO> getPedido(@PathVariable Long id) {
        Pedido pedido = service.getPedido(id);
        return ResponseEntity.ok(new RespuestaPedidoDTO(pedido));
    }


}
