package com.co.indra.coinmarketcap.coins.model.responses;

import com.co.indra.coinmarketcap.coins.model.entities.CoinApi;

import java.io.Serializable;

public class CoinApiResponse implements Serializable {
    private CoinApi data;

    private Double timestamp;

    public CoinApiResponse(CoinApi data, Double timestamp) {
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
