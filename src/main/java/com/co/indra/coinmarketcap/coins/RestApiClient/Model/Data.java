package com.co.indra.coinmarketcap.coins.RestApiClient.Model;

import java.util.List;

public class Data {

    private CoinApiExterna data;
    private Double timestamp;

    public Data() {
    }

    public Data(CoinApiExterna data, Double timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    public CoinApiExterna getData() {
        return data;
    }

    public void setData(CoinApiExterna data) {
        this.data = data;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
}
