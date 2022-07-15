package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.PriceETHRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceETH;
import com.myProject.cryptoCurrencyWatcher.service.ConnectionAndRequest;
import com.myProject.cryptoCurrencyWatcher.service.PriceETHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service("priceETHService")
@Transactional
public class PriceETHServiceImpl implements PriceETHService {

    private final PriceETHRepository priceETHRepository;

    @Autowired
    public PriceETHServiceImpl(PriceETHRepository priceETHRepository) {
        this.priceETHRepository = priceETHRepository;
    }

    @Override
    public BigDecimal getPriceETH() {
        BigDecimal priceEth = priceETHRepository.findPriceETH();
        return priceEth;
    }

    @Override
    @Scheduled(fixedDelay = 60 * 1000)
    public PriceETH createPriceETH() {
        PriceETH priceETH = new PriceETH();

        try {
            ConnectionAndRequest connectionAndRequest = new ConnectionAndRequest();
            priceETH.setPriceETH(connectionAndRequest
                    .priceCurrenyFromRequest("https://api.coinlore.net/api/ticker/?id=80"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDateTime dateTime = LocalDateTime.now();
        priceETH.setRequestTime(dateTime);

        return priceETHRepository.save(priceETH);
    }
}
