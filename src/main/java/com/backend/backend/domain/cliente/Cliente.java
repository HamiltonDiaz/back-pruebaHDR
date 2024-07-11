package com.backend.backend.domain.cliente;

import com.backend.backend.domain.base.Base;
import jakarta.persistence.*;
import lombok.*;

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
}
