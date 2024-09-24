package com.rb.ppm.core.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "proveedores")
@Data
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @Column(name = "nombre_empresa")
    private String businessName;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<ProductEntity> products;

}