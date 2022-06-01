package com.co.indra.coinmarketcap.coins.externalApi;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoinApiClientAssets {

    private List<CoinApi> data;

    private Double timestamp;

    public CoinApiClientAssets() {
    }

    public CoinApiClientAssets(List<CoinApi> data, Double timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    public List<CoinApi> getData() {
        return data;
    }

    public void setData(List<CoinApi> data) {
        this.data = data;
    }


    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
}
