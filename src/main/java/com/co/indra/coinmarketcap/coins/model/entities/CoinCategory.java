package com.co.indra.coinmarketcap.coins.model.entities;

import java.io.Serializable;

public class CoinCategory implements Serializable {
    private String idSymbolCoin;
    private Long idCategory;

    public CoinCategory() {
    }

    public CoinCategory(String idSymbolCoin, Long idCategory) {
        this.idSymbolCoin = idSymbolCoin;
        this.idCategory = idCategory;
    }

    public String getIdSymbolCoin() {
        return idSymbolCoin;
    }

    public void setIdSymbolCoin(String idSymbolCoin) {
        this.idSymbolCoin = idSymbolCoin;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }
}
