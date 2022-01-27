package io.github.gabrielhgcamargo.model;

import io.github.gabrielhgcamargo.enums.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoiceId;

    @Column
    private Market market;

    @Column
    private final LocalDateTime dateIssue = LocalDateTime.now();

    @Column
    private LocalDateTime deliveryForecast;

    @Column
    private Map<Integer, Product> products;

    @Column
    private InvoiceStatus status;

}
