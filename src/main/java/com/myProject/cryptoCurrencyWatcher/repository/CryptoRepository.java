package com.myProject.cryptoCurrencyWatcher.repository;

import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<Crypto, String> {
}
