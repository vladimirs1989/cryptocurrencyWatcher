package com.myProject.cryptoCurrencyWatcher.service.impl;

import com.myProject.cryptoCurrencyWatcher.repository.PriceETHRepository;
import com.myProject.cryptoCurrencyWatcher.repository.entity.PriceETH;
import com.myProject.cryptoCurrencyWatcher.service.PriceETHService;
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

@Service("priceETHService")
@Transactional
public class PriceETHServiceImpl implements PriceETHService {

    private PriceETHRepository priceETHRepository;

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
            priceETH.setPriceETH(priceEthFromRequest());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDateTime dateTime = LocalDateTime.now();
        priceETH.setRequestTime(dateTime);

        return priceETHRepository.save(priceETH);
    }

    public BigDecimal priceEthFromRequest() throws IOException {
        final URL url = new URL("https://api.coinlore.net/api/ticker/?id=80");
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
            return parse(s.substring(1, s.length() - 1));

        } catch (final Exception ex) {
            ex.printStackTrace();
            return BigDecimal.ZERO;
        }

    }

    public static BigDecimal parse(String responseBody) {
        JSONObject obj = new JSONObject(responseBody);
        BigDecimal price = obj.getBigDecimal("price_usd");
        return price;
    }

}
