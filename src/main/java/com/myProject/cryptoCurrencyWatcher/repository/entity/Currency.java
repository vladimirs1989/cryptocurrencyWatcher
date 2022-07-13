package com.myProject.cryptoCurrencyWatcher.repository.entity;

import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class Currency {
    private  Long id;
    private  String symbol;
//    private  String name;
//    private  String nameid;
//    private  Integer rank;
//    private  BigDecimal price_usd;
//    private  BigDecimal percent_change_24h;
//    private  BigDecimal percent_change_1h;
//    private  BigDecimal percent_change_7d;
//    private  BigDecimal market_cap_usd;
//    private  BigDecimal volume24;;
//    private  BigDecimal csupply;
//    private  BigDecimal price_btc;
//    private  Long tsupply;
//    private  Long msupply;
}
