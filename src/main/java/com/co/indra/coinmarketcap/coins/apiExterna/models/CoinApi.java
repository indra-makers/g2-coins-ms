package com.co.indra.coinmarketcap.coins.apiExterna.models;

import java.io.Serializable;

public class CoinApi implements Serializable {

    private String symbol;
    private String name;
    private String icon;

    public CoinApi() {
    }

    public CoinApi(String symbol, String name, String icon) {
        this.symbol = symbol;
        this.name = name;
        this.icon = icon;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
