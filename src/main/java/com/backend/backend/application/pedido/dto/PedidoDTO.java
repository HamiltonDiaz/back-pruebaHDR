package com.backend.backend.application.pedido.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public record PedidoDTO(
            Long id,
            @NotNull
            Long idCliente,
            @NotNull
            Long idProducto,
            @NotNull
            Long idBodega,
            @NotNull
            BigInteger cantidadProducto,

            LocalDate fechaDeEntrega,

            @NotNull
            BigDecimal precioDeEnvio,


            String idetentificacionVehiculo,
            String numeroDeguia,
            LocalDate fechaDeCreacion,
            LocalDate fechaDeModificacion

) {
}
