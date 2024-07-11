package com.backend.backend.domain.cliente;

import com.backend.backend.domain.base.Base;
import com.backend.backend.domain.bodega.Bodega;
import com.backend.backend.domain.pedido.Pedido;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "clientes")
@Entity(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
public class Cliente extends Base {


    private String nombre;
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String documento;
    private String direccion;
    private Boolean activo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedido;
}
