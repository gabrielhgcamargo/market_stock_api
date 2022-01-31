package io.github.gabrielhgcamargo.service;

import io.github.gabrielhgcamargo.dto.InvoiceDTO;
import io.github.gabrielhgcamargo.model.Invoice;

import java.util.Optional;

public interface InvoiceService {

    Invoice save(InvoiceDTO dto);

    Optional<Invoice> getCompleteInvoice(Integer id);

}
