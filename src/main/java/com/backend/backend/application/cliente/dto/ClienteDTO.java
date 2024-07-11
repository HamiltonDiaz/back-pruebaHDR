package com.backend.backend.application.cliente.dto;

import com.backend.backend.domain.cliente.TipoDocumento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDTO(
        Long id ,
        @NotBlank (message = "Nombre es requerido")
        String nombre,

        @NotBlank (message = "Correo requerido")
        @Email(message = "Formato de correo electrónico incorrecto")
        String email,
        @NotNull (message = "Tipo de documento es requerido")
        TipoDocumento tipoDocumento,
        @NotBlank(message = "Documento es requerido")
        String documento,
        @NotBlank(message = "Direccion es requerida")
        String direccion,

        Boolean activo,
        LocalDate fechaDeCreacion,
        LocalDate fechaDeModificacion
) {
}