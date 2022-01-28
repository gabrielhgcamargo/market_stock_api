package io.github.gabrielhgcamargo.model;

import io.github.gabrielhgcamargo.enums.InvoiceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer invoiceId;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @Column
    private final LocalDate dateIssue = LocalDate.now();

    @Column
    private LocalDate deliveryForecast;

    @Column(precision = 20, scale = 2)
    private BigDecimal totalPrice;

    @Column
    private InvoiceStatus status;

    @OneToMany(mappedBy = "invoice")
    private List<ProductInvoice> productInvoices;


}
