package io.github.gabrielhgcamargo.repository;

import io.github.gabrielhgcamargo.model.Invoice;
import io.github.gabrielhgcamargo.model.Market;
import io.github.gabrielhgcamargo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    List<Product> findByMarket(Market market);

}

