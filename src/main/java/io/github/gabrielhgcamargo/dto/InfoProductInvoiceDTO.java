package io.github.gabrielhgcamargo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoProductInvoiceDTO {
    private String name;
    private Integer id;
    private String upc;
    private BigDecimal unitPrice;
    private Integer quantity;

}
