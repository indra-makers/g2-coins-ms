package com.co.indra.coinmarketcap.coins.model.entities;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class HistoryCoin implements Serializable {
    private Long idHistoryCoin;

    private String idSymbolCoin;
    private Long actualPrice;
    private Long variation24h;
    private Long variation7d;
    private Long marketCap;
    private Long volume24h;
    private Long circulatingSupply;

    public HistoryCoin() {
    }

    public HistoryCoin(Long idHistoryCoin, String idSymbolCoin, Long actualPrice, Long variation24h, Long variation7d, Long marketCap, Long volume24h, Long circulatingSupply) {
        this.idHistoryCoin = idHistoryCoin;
        this.idSymbolCoin = idSymbolCoin;
        this.actualPrice = actualPrice;
        this.variation24h = variation24h;
        this.variation7d = variation7d;
        this.marketCap = marketCap;
        this.volume24h = volume24h;
        this.circulatingSupply = circulatingSupply;
    }

    public Long getIdHistoryCoin() {
        return idHistoryCoin;
    }

    public void setIdHistoryCoin(Long idHistoryCoin) {
        this.idHistoryCoin = idHistoryCoin;
    }

    public String getIdSymbolCoin() {
        return idSymbolCoin;
    }

    public void setIdSymbolCoin(String idSymbolCoin) {
        this.idSymbolCoin = idSymbolCoin;
    }

    public Long getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Long actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Long getVariation24h() {
        return variation24h;
    }

    public void setVariation24h(Long variation24h) {
        this.variation24h = variation24h;
    }

    public Long getVariation7d() {
        return variation7d;
    }

    public void setVariation7d(Long variation7d) {
        this.variation7d = variation7d;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Long getVolume24h() {
        return volume24h;
    }

    public void setVolume24h(Long volume24h) {
        this.volume24h = volume24h;
    }

    public Long getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Long circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }
}
