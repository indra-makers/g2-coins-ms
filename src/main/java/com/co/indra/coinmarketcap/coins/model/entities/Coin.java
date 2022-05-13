package com.co.indra.coinmarketcap.coins.model.entities;

import java.io.Serializable;

public class Coin implements Serializable{
    private String idSymbolCoin;
    private String nameCoin;
    private String iconCoin;

    public Coin() {
    }

    public Coin(String idSymbolCoin, String nameCoin, String iconCoin) {
        this.idSymbolCoin = idSymbolCoin;
        this.nameCoin = nameCoin;
        this.iconCoin = iconCoin;
    }

    public String getIdSymbolCoin() {
        return idSymbolCoin;
    }

    public void setIdSymbolCoin(String idSymbolCoin) {
        this.idSymbolCoin = idSymbolCoin;
    }

    public String getNameCoin() {
        return nameCoin;
    }

    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }

    public String getIconCoin() {
        return iconCoin;
    }

    public void setIconCoin(String iconCoin) {
        this.iconCoin = iconCoin;
    }
}
