package com.myProject.cryptoCurrencyWatcher.repository.entity;

public enum Currencies {
    BTC ("90"),
    ETH ("80"),
    SOL ("48543");
    private  String symbol;
    Currencies (String symbol){
        this.symbol=symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
