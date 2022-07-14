package com.myProject.cryptoCurrencyWatcher.service;

import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceETH;

import java.math.BigDecimal;

public interface PriceETHService {

    BigDecimal getPriceETH();

    PriceETH createPriceETH();

}
