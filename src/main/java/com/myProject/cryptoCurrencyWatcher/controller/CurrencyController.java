package com.myProject.cryptoCurrencyWatcher.controller;

import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;
import com.myProject.cryptoCurrencyWatcher.service.CryptoService;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import com.myProject.cryptoCurrencyWatcher.service.PriceETHService;
import com.myProject.cryptoCurrencyWatcher.service.PriceSOLService;
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
    private PriceSOLService priceSOLService;

    @Autowired
    public CurrencyController(CryptoService cryptoService,
                              PriceBTCService priceBTCService,
                              PriceETHService priceETHService,
                              PriceSOLService priceSOLService) {
        this.cryptoService = cryptoService;
        this.priceBTCService = priceBTCService;
        this.priceETHService = priceETHService;
        this.priceSOLService = priceSOLService;
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

    @GetMapping("/SOL")
    public BigDecimal priceSol() {
        return priceSOLService.getPriceSOL();
    }

    @GetMapping("/doBTH")
    public String listsB() throws IOException {
        return priceBTCService.createPriceBTC().toString();
    }

    @GetMapping("/doETH")
    public String listsE() throws IOException {
        return priceETHService.createPriceETH().toString();
    }

    @GetMapping("/doSOL")
    public String listsS() throws IOException {
        return priceSOLService.createPriceSOL().toString();
    }
}
