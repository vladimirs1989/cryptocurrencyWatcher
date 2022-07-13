package com.myProject.cryptoCurrencyWatcher.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table (name = "pricecryptocurrencies")
public class PriceCryptoСurrencies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "requestTime")
    Timestamp requestTime;

    @Column(name = "priceBTC")
    BigDecimal priceBTC;

    @Column(name = "priceETH")
    BigDecimal priceETH;

    @Column(name = "priceSOL")
    BigDecimal priceSOL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    public BigDecimal getPriceBTC() {
        return priceBTC;
    }

    public void setPriceBTC(BigDecimal priceBTC) {
        this.priceBTC = priceBTC;
    }

    public BigDecimal getPriceETH() {
        return priceETH;
    }

    public void setPriceETH(BigDecimal priceETH) {
        this.priceETH = priceETH;
    }

    public BigDecimal getPriceSOL() {
        return priceSOL;
    }

    public void setPriceSOL(BigDecimal priceSOL) {
        this.priceSOL = priceSOL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceCryptoСurrencies that = (PriceCryptoСurrencies) o;
        return Objects.equals(id, that.id) && Objects.equals(requestTime, that.requestTime) && Objects.equals(priceBTC, that.priceBTC) && Objects.equals(priceETH, that.priceETH) && Objects.equals(priceSOL, that.priceSOL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestTime, priceBTC, priceETH, priceSOL);
    }

    @Override
    public String toString() {
        return "PriceCryptoСurrencies{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", priceBTC=" + priceBTC +
                ", priceETH=" + priceETH +
                ", priceSOL=" + priceSOL +
                '}';
    }
}
