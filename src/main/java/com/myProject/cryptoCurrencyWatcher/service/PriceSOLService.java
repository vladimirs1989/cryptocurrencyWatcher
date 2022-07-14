package com.myProject.cryptoCurrencyWatcher.service;

import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceBTC;
import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceSOL;

import java.math.BigDecimal;

public interface PriceSOLService {

    BigDecimal getPriceSOL();

    PriceSOL createPriceSOL();

}
