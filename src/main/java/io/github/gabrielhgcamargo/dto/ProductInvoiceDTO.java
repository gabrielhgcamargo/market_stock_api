package io.github.gabrielhgcamargo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInvoiceDTO {
    private Integer product;
    private Integer quantity;
}
