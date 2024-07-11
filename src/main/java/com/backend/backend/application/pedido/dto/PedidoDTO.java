package com.backend.backend.application.pedido.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

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

            String fechaDeEntrega,

            @NotNull
            BigDecimal precioDeEnvio,

            @NotBlank
            String idetentificacionVehiculo,

            String numeroDeguia,
            LocalDate fechaDeCreacion,
            LocalDate fechaDeModificacion

) {
}
