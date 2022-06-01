package com.co.indra.coinmarketcap.coins.externalApi;

public class CoinApiClientAsset {

    private CoinApi data;

    private Double timestamp;

    public CoinApiClientAsset() {
    }

    public CoinApiClientAsset(CoinApi data, Double timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    public CoinApi getData() {
        return data;
    }

    public void setData(CoinApi data) {
        this.data = data;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
}
