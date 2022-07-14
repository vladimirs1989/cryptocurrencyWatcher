package com.myProject.cryptoCurrencyWatcher.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "userchosesymbol")
    @Enumerated(EnumType.STRING)
    private String userChoseSymbol;

    @Column(name = "pricecurrency")
    private BigDecimal priceCurrency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserChoseSymbol() {
        return userChoseSymbol;
    }

    public void setUserChoseSymbol(String userChoseSymbol) {
        this.userChoseSymbol = userChoseSymbol;
    }

    public BigDecimal getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(BigDecimal priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && userChoseSymbol == user.userChoseSymbol && Objects.equals(priceCurrency, user.priceCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userChoseSymbol, priceCurrency);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userChangeSymbol=" + userChoseSymbol +
                ", pricecurrency=" + priceCurrency +
                '}';
    }
}
