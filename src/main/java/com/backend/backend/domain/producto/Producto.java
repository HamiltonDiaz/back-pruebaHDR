package com.backend.backend.domain.producto;

import com.backend.backend.domain.base.Base;
import com.backend.backend.domain.pedido.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Pedido> pedido;
}
