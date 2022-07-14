package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.CryptoRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;
import com.myProject.cryptoCurrencyWatcher.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("cryptoService")
@Transactional
public class CryptoServiceImpl implements CryptoService {


    private CryptoRepository cryptoRepository;

    @Autowired
    public void setCryptoRepository(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    @Override
    public List<Crypto> getAllCryptos() {
        return cryptoRepository.findAll().stream().collect(Collectors.toList());
    }
}
