package com.myProject.cryptoCurrencyWatcher.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "price_btc")
public class PriceBTC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "request_time")
    LocalDateTime requestTime;

    @Column(name = "price_btc")
    BigDecimal priceBTC;

    public PriceBTC() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public BigDecimal getPriceBTC() {
        return priceBTC;
    }

    public void setPriceBTC(BigDecimal priceBTC) {
        this.priceBTC = priceBTC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceBTC priceBTC1 = (PriceBTC) o;
        return Objects.equals(id, priceBTC1.id) && Objects.equals(requestTime, priceBTC1.requestTime) && Objects.equals(priceBTC, priceBTC1.priceBTC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestTime, priceBTC);
    }

    @Override
    public String toString() {
        return "PriceBTCService{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", priceBTC=" + priceBTC +
                '}';
    }
}
