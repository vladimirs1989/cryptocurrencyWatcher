package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.PriceBTCRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceBTC;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

@Service("priceBTCService")
@Transactional
public class PriceBTCServiceImpl implements PriceBTCService {

    private PriceBTCRepository priceBTCRepository;

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
            priceBTC.setPriceBTC(priceBtcFromRequest());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime dateTime = LocalDateTime.now();
        priceBTC.setRequestTime(dateTime);

        return priceBTCRepository.save(priceBTC);
    }

    public BigDecimal priceBtcFromRequest() throws IOException {
        final URL url = new URL("https://api.coinlore.net/api/ticker/?id=90");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(1000000);
        con.setReadTimeout(1000000);
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            String s = content.toString();
            in.close();
            return parse(s.substring(1, s.length() - 1));

        } catch (final Exception ex) {
            ex.printStackTrace();
            return BigDecimal.TEN;
        }

    }

    public static BigDecimal parse(String responseBody) {
        JSONObject obj = new JSONObject(responseBody);
        BigDecimal price = obj.getBigDecimal("price_usd");
        return price;
    }

}
