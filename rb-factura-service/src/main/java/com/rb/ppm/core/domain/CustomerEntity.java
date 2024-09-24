package com.rb.ppm.core.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre", length = 100)
    private String name;

    @Column(name = "apellido", length = 100)
    private String lastName;

    @Column(name = "direccion", columnDefinition = "TEXT")
    private String address;

    @Column(name = "cedula", length = 10)
    private String identification;
}
