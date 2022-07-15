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
@Table(name = "price_sol")
public class PriceSOL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "request_time")
    LocalDateTime requestTime;

    @Column(name = "price_sol")
    BigDecimal priceSOL;

    public PriceSOL() {
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
        PriceSOL priceSOL1 = (PriceSOL) o;
        return Objects.equals(id, priceSOL1.id) && Objects.equals(requestTime, priceSOL1.requestTime) && Objects.equals(priceSOL, priceSOL1.priceSOL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestTime, priceSOL);
    }

    @Override
    public String toString() {
        return "PriceSOL{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", priceSOL=" + priceSOL +
                '}';
    }
}
