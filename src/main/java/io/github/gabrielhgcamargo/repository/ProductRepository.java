package io.github.gabrielhgcamargo.repository;

import io.github.gabrielhgcamargo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
