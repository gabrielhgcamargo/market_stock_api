package io.github.gabrielhgcamargo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDTO {
    private String market;
    private BigDecimal total;
    private List<ProductInvoiceDTO> items;
}
