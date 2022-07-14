package com.myProject.cryptoCurrencyWatcher.repository;

import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;
import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceBTC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PriceBTCRepository extends JpaRepository<PriceBTC, BigDecimal> {

    @Query(value = "select price_btc from price_btc order by request_time DESC LIMIT 1", nativeQuery = true)
    BigDecimal findPriceBTC();
}
