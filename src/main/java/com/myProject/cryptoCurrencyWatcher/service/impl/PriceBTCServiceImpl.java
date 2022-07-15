package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.PriceBTCRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceBTC;
import com.myProject.cryptoCurrencyWatcher.service.ConnectionAndRequest;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service("priceBTCService")
@Transactional
public class PriceBTCServiceImpl implements PriceBTCService {

    private final PriceBTCRepository priceBTCRepository;

    @Autowired
    public PriceBTCServiceImpl(PriceBTCRepository priceBTCRepository) {
        this.priceBTCRepository = priceBTCRepository;
    }

    @Override
    public BigDecimal getPriceBTC() {
        BigDecimal priceBtc = priceBTCRepository.findPriceBTC();
        return priceBtc;
    }

    @Override
    @Scheduled(fixedDelay = 60 * 1000)
    public PriceBTC createPriceBTC() {
        PriceBTC priceBTC = new PriceBTC();
        try {
            ConnectionAndRequest connectionAndRequest = new ConnectionAndRequest();
            priceBTC.setPriceBTC(connectionAndRequest
                    .priceCurrenyFromRequest("https://api.coinlore.net/api/ticker/?id=90"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime dateTime = LocalDateTime.now();
        priceBTC.setRequestTime(dateTime);

        return priceBTCRepository.save(priceBTC);
    }
}
