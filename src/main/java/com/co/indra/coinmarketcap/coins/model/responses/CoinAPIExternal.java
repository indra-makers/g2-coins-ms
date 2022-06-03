package com.co.indra.coinmarketcap.coins.model.responses;

import java.io.Serializable;

public class CoinAPIExternal implements Serializable {
        private String id;
        private int rank;
        private String symbol;
        private String name;
        private Double supply;
        private Double maxSupply;
        private Double marketCapUsd;
        private Double volumeUsd24Hr;
        private Double priceUsd;
        private Double changePercent24Hr;
        private Double vwap24Hr;
        private String explorer;

    public CoinAPIExternal(String id, int rank, String symbol, String name, Double supply, Double maxSupply, Double marketCapUsd, Double volumeUsd24Hr, Double priceUsd, Double changePercent24Hr, Double vwap24Hr, String explorer) {
        this.id = id;
        this.rank = rank;
        this.symbol = symbol;
        this.name = name;
        this.supply = supply;
        this.maxSupply = maxSupply;
        this.marketCapUsd = marketCapUsd;
        this.volumeUsd24Hr = volumeUsd24Hr;
        this.priceUsd = priceUsd;
        this.changePercent24Hr = changePercent24Hr;
        this.vwap24Hr = vwap24Hr;
        this.explorer = explorer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public Double getSupply() {
        return supply;
    }

    public void setSupply(Double supply) {
        this.supply = supply;
    }

    public Double getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Double maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Double getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(Double marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public Double getVolumeUsd24Hr() {
        return volumeUsd24Hr;
    }

    public void setVolumeUsd24Hr(Double volumeUsd24Hr) {
        this.volumeUsd24Hr = volumeUsd24Hr;
    }

    public Double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(Double priceUsd) {
        this.priceUsd = priceUsd;
    }

    public Double getChangePercent24Hr() {
        return changePercent24Hr;
    }

    public void setChangePercent24Hr(Double changePercent24Hr) {
        this.changePercent24Hr = changePercent24Hr;
    }

    public Double getVwap24Hr() {
        return vwap24Hr;
    }

    public void setVwap24Hr(Double vwap24Hr) {
        this.vwap24Hr = vwap24Hr;
    }

    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
    }
}
