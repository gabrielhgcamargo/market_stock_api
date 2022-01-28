package io.github.gabrielhgcamargo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Invoice invoice;

    @ManyToOne
    @JoinColumn
    private Product product;

    @Column
    private Integer quantity;
}
