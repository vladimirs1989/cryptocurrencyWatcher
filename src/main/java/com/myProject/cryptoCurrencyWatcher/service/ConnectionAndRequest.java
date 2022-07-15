package com.myProject.cryptoCurrencyWatcher.service;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionAndRequest {
    public BigDecimal priceCurrenyFromRequest(String uri) throws IOException {
        final URL url = new URL(uri);
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
            return BigDecimal.ZERO;
        } finally {
            con.disconnect();
        }
    }

    public static BigDecimal parse(String responseBody) {
        JSONObject obj = new JSONObject(responseBody);
        BigDecimal price = obj.getBigDecimal("price_usd");
        return price;
    }
}
