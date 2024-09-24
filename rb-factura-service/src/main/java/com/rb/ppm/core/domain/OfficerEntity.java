package com.rb.ppm.core.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "oficial")
@Data
public class OfficerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "usuario")
    private String userName;

    @Column(name = "contrasenia")
    private String password;

}
