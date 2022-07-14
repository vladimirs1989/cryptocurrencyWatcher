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
@Table(name = "price_eth")
public class PriceETH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "request_time")
    LocalDateTime requestTime;

    @Column(name = "price_eth")
    BigDecimal priceETH;

    public PriceETH() {
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

    public BigDecimal getPriceETH() {
        return priceETH;
    }

    public void setPriceETH(BigDecimal priceETH) {
        this.priceETH = priceETH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceETH priceETH1 = (PriceETH) o;
        return Objects.equals(id, priceETH1.id) && Objects.equals(requestTime, priceETH1.requestTime) && Objects.equals(priceETH, priceETH1.priceETH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestTime, priceETH);
    }

    @Override
    public String toString() {
        return "PriceETH{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", priceETH=" + priceETH +
                '}';
    }
}
