package com.backend.backend.application.pedido.service.impl;

import com.backend.backend.application.pedido.dto.PedidoDTO;
import com.backend.backend.application.pedido.service.IPedidoService;
import com.backend.backend.domain.pedido.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements IPedidoService {
    @Override
    public Pedido createPedido(PedidoDTO pedidoDTO) {
        return null;
    }

    @Override
    public Pedido getPedido(Long id) {
        return null;
    }
}
