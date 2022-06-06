package com.co.indra.coinmarketcap.coins.apiExterna.models.coincap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class coincapData {

    @JsonProperty("id")
    private String name;

    private String symbol;

    @JsonProperty("explorer")
    private String icono;

    public coincapData() {
    }

    public coincapData(String name, String symbol, String icono) {
        this.name = name;
        this.symbol = symbol;
        this.icono = icono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
