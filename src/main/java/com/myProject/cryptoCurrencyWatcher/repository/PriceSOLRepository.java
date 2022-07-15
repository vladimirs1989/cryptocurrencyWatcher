package com.myProject.cryptoCurrencyWatcher.repository;

import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceSOL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PriceSOLRepository extends JpaRepository<PriceSOL, BigDecimal> {

    @Query(value = "select price_sol from price_sol order by request_time DESC LIMIT 1", nativeQuery = true)
    BigDecimal findPriceSOL();
}
