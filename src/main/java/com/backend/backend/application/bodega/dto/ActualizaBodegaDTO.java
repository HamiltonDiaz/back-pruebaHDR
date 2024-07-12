package com.backend.backend.application.bodega.dto;

import com.backend.backend.domain.bodega.TipoBodega;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ActualizaBodegaDTO(
        @NotNull
        Long id,

        @NotBlank(message = "Nombre es requerido")
        String nombre,
        @NotBlank(message = "Direccion es requerida")
        String direccion,
        @NotBlank(message = "Ciudad es requerida")
        String ciudad,
        @NotBlank(message = "Estado es requerido")
        String estado,
        @NotBlank(message = "País es requerido")
        String pais,
        @NotBlank(message = "Código postal es requerido")
        String codigoPostal,

        @NotNull()
        BigDecimal capacidadAlmacenamiento,

        BigDecimal capacidadDisponible,
        String responsable,
        String telefonoContacto,

        @Email(message = "Formato de correo electrónico incorrecto")
        String emailContacto,

        @NotNull(message = "Tipo de bodega es requerido")
        TipoBodega tipoBodega
) {
}
