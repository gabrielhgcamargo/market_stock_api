package io.github.gabrielhgcamargo.repository;

import io.github.gabrielhgcamargo.model.Invoice;
import io.github.gabrielhgcamargo.model.Market;
import io.github.gabrielhgcamargo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    List<Product> findByMarket(Market market);

    @Query("select p from Invoice p left join fetch p.productInvoices where p.id = :id")
    Optional<Invoice> findByIdFetchItems(@Param("id") Integer id);

}

