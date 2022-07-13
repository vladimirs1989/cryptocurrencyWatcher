package com.myProject.cryptoCurrencyWatcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("currencies")

public class CurencyController {
    public List<Map<String, String>> currencies = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "90");
            put("symbol", "BTC");
        }});
        add(new HashMap<String, String>() {{
            put("id", "80");
            put("symbol", "ETH");
        }});
        add(new HashMap<String, String>() {{
            put("id", "48543");
            put("symbol", "SOL");
        }});
    }};

    @GetMapping
    public List<Map<String, String>> list() {
        return currencies;
    }
}
