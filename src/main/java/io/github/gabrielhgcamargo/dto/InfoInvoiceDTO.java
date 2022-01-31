package io.github.gabrielhgcamargo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoInvoiceDTO {
    private Integer idInvoice;
    private String marketName;
    private String marketCNPJ;
    private BigDecimal total;
    private String dateIssue;
    private String deliveryForecast;
    private String status;
    private List<InfoProductInvoiceDTO> items;

}
