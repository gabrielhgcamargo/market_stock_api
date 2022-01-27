package io.github.gabrielhgcamargo.repository;

import io.github.gabrielhgcamargo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
