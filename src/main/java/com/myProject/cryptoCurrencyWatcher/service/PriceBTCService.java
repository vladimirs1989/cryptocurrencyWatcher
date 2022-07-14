package com.myProject.cryptoCurrencyWatcher.service;

import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceBTC;

import java.math.BigDecimal;

public interface PriceBTCService {

    BigDecimal getPriceBTC();

    PriceBTC createPriceBTC ();

}
