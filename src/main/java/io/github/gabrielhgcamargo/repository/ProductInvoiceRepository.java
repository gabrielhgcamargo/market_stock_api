package io.github.gabrielhgcamargo.repository;

import io.github.gabrielhgcamargo.model.ProductInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Integer> {
}
