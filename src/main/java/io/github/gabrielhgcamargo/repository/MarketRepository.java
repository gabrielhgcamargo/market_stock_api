package io.github.gabrielhgcamargo.repository;

import io.github.gabrielhgcamargo.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MarketRepository extends JpaRepository<Market, String>{

}
