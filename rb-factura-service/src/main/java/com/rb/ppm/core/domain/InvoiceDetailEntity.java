package com.rb.ppm.core.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "detalle_factura")
@Data
public class InvoiceDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    private InvoiceEntity invoice;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private ProductEntity product;

    @Column(name = "cantidad")
    private Integer quantity;
}
