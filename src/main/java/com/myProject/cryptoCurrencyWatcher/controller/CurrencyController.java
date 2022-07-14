package com.myProject.cryptoCurrencyWatcher.controller;


import com.myProject.cryptoCurrencyWatcher.repository.entity.Crypto;
import com.myProject.cryptoCurrencyWatcher.service.CryptoService;
import com.myProject.cryptoCurrencyWatcher.service.PriceBTCService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/currencies")

public class CurrencyController {

    private CryptoService cryptoService;
    private PriceBTCService priceBTCService;

    @Autowired
    public CurrencyController(CryptoService cryptoService, PriceBTCService priceBTCService) {
        this.cryptoService = cryptoService;
        this.priceBTCService = priceBTCService;
    }

    @GetMapping
    public List<Crypto> list() {
        List<Crypto> cryptos = cryptoService.getAllCryptos();
        return cryptos;
    }

    @GetMapping("/BTC")
    public BigDecimal priceBtc() {
        return priceBTCService.getPriceBTC();
    }

    @GetMapping("/do")
    public String lists() throws IOException {
        return priceBTCService.createPriceBTC().toString();
    }
       /* final URL url = new URL("https://api.coinlore.net/api/ticker/?id=90");
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
            //parse(s.substring(1, s.length() - 1));

            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }*/

       /* HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.coinlore.net/api/ticker/?id=90")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join()

    };*/

    /*public static String parse(String responseBody) {

        JSONObject obj = new JSONObject(responseBody);
        int id = obj.getInt("id");
        String symbol = obj.getString("symbol");
        BigDecimal price = obj.getBigDecimal("price_usd");
        System.out.println(id + " " + symbol + " " + price);
        return null;
    }*/

}
