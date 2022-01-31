package io.github.gabrielhgcamargo.service;

import io.github.gabrielhgcamargo.dto.InvoiceDTO;
import io.github.gabrielhgcamargo.model.Invoice;

public interface InvoiceService {

    Invoice save(InvoiceDTO dto);

}
