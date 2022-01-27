package io.github.gabrielhgcamargo.repository;

import io.github.gabrielhgcamargo.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, String>{
}
