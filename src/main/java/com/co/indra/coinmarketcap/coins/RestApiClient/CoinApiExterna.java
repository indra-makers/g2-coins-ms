package com.co.indra.coinmarketcap.coins.RestApiClient;

public class CoinApiExterna {

    private String id;
    private String symbol;
    private String name;

    public CoinApiExterna(){

    }

    public CoinApiExterna(String id, String symbol, String name) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
