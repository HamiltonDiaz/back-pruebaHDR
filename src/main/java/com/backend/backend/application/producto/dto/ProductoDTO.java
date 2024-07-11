package com.backend.backend.application.producto.dto;


import com.backend.backend.domain.producto.CategoriaProducto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public record ProductoDTO(
        Long id,
        @NotBlank(message = "Nombre es requerido")
        String nombre,
        @NotBlank(message = "Descripcion es requerida")
        String descripcion,

        @NotNull
        CategoriaProducto categoriaProducto,

        Boolean activo,
        LocalDate fechaDeCreacion,
        LocalDate fechaDeModificacion
) {

}
