package com.myProject.cryptoCurrencyWatcher.service;

import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;

import java.util.List;

public interface CryptoService {

    List<Crypto> getAllCryptos();
}
