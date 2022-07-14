package com.myProject.cryptoCurrencyWatcher.controller;

import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;
import com.myProject.cryptoCurrencyWatcher.repository.entity.User;
import com.myProject.cryptoCurrencyWatcher.service.CryptoService;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import com.myProject.cryptoCurrencyWatcher.service.PriceETHService;
import com.myProject.cryptoCurrencyWatcher.service.PriceSOLService;
import com.myProject.cryptoCurrencyWatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private UserService userService;

    @Autowired
    public CurrencyController(CryptoService cryptoService,
                              PriceBTCService priceBTCService,
                              PriceETHService priceETHService,
                              PriceSOLService priceSOLService,
                              UserService userService) {
        this.cryptoService = cryptoService;
        this.priceBTCService = priceBTCService;
        this.priceETHService = priceETHService;
        this.priceSOLService = priceSOLService;
        this.userService = userService;
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

    @GetMapping("/notyfy")
    public  String Create (@RequestParam String userName,
                           @RequestParam String symbol){
        User user = new User();
        user.setUserName(userName);
        user.setUserChoseSymbol(symbol);
        User createdUser = userService.createUser(user);
        //user.setPriceCurrency();
        return createdUser.toString();
    }



    //for testing
    @GetMapping("/doBTC")
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

    @GetMapping("symbol/{symbol}")
    public String execute( @PathVariable String symbol) {
        List<User> users = userService.findBySymbol(symbol);
        return users.toString();
    }
}
