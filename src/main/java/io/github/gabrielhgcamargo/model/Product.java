package io.github.gabrielhgcamargo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String upc;
    private String name;
    private Integer quantity;
    private BigDecimal unitPrice;
}
