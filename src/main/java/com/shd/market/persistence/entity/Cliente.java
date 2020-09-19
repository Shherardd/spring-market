package com.shd.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "id")
    private String idCliente;

    private String nombre;

    private String apellidos;

    private Integer celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

}
