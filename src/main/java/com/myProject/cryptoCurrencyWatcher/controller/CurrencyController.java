package com.myProject.cryptoCurrencyWatcher.controller;

import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;
import com.myProject.cryptoCurrencyWatcher.service.CryptoService;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import com.myProject.cryptoCurrencyWatcher.service.PriceETHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/currencies")

public class CurrencyController {

    private CryptoService cryptoService;
    private PriceBTCService priceBTCService;
    private PriceETHService priceETHService;

    @Autowired
    public CurrencyController(CryptoService cryptoService, PriceBTCService priceBTCService, PriceETHService priceETHService) {
        this.cryptoService = cryptoService;
        this.priceBTCService = priceBTCService;
        this.priceETHService = priceETHService;
    }

    @GetMapping
    public List<Crypto> listCryptoCurrency() {
        List<Crypto> cryptos = cryptoService.getAllCryptos();
        return cryptos;
    }

    @GetMapping("/BTC")
    public BigDecimal priceBtc() {
        return priceBTCService.getPriceBTC();
    }

    @GetMapping("/ETH")
    public BigDecimal priceEth() {
        return priceETHService.getPriceETH();
    }

    @GetMapping("/doBTH")
    public String listsB() throws IOException {
        return priceBTCService.createPriceBTC().toString();
    }

    @GetMapping("/doETH")
    public String listsE() throws IOException {
        return priceETHService.createPriceETH().toString();
    }
}
