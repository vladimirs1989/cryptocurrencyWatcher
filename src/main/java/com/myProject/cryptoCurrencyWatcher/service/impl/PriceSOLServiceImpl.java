package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.PriceSOLRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceSOL;
import com.myProject.cryptoCurrencyWatcher.service.ConnectionAndRequest;
import com.myProject.cryptoCurrencyWatcher.service.PriceSOLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service("priceSOLService")
@Transactional
public class PriceSOLServiceImpl implements PriceSOLService {

    private final PriceSOLRepository priceSOLRepository;

    @Autowired
    public PriceSOLServiceImpl(PriceSOLRepository priceSOLRepository) {
        this.priceSOLRepository = priceSOLRepository;
    }

    @Override
    public BigDecimal getPriceSOL() {
        BigDecimal priceSol = priceSOLRepository.findPriceSOL();
        return priceSol;
    }

    @Override
    @Scheduled(fixedDelay = 60 * 1000)
    public PriceSOL createPriceSOL() {
        PriceSOL priceSOL = new PriceSOL();

        try {
            ConnectionAndRequest connectionAndRequest = new ConnectionAndRequest();
            priceSOL.setPriceSOL(connectionAndRequest
                    .priceCurrenyFromRequest("https://api.coinlore.net/api/ticker/?id=48543"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDateTime dateTime = LocalDateTime.now();
        priceSOL.setRequestTime(dateTime);

        return priceSOLRepository.save(priceSOL);
    }
}
