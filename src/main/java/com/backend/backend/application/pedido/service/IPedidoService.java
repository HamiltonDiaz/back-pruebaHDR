package com.backend.backend.application.pedido.service;

import com.backend.backend.application.pedido.dto.PedidoDTO;
import com.backend.backend.domain.pedido.Pedido;

public interface IPedidoService {
    Pedido createPedido(PedidoDTO pedidoDTO);
    Pedido getPedido(Long id);

    Pedido findPedidoPorNumeroDeGuia(String numeroDeGuia);
}
