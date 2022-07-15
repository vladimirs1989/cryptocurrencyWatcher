package com.myProject.cryptoCurrencyWatcher.repository;

import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceETH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PriceETHRepository extends JpaRepository<PriceETH, BigDecimal> {

    @Query(value = "select price_eth from price_eth where price_eth != 0 order by request_time DESC LIMIT 1", nativeQuery = true)
    BigDecimal findPriceETH();
}
