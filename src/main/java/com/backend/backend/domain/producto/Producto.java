package com.backend.backend.domain.producto;

import com.backend.backend.domain.base.Base;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "productos")
@Entity(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
public class Producto extends Base {
    private String nombre;
    private Boolean activo;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private CategoriaProducto categoriaProducto;
}
