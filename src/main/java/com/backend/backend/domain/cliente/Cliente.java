package com.backend.backend.domain.cliente;

import com.backend.backend.domain.base.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Cliente extends Base {

    private String nombre;
    private String email;
    private String tipoDeDocumento;
    private String documento;
    private String direccion;
}
