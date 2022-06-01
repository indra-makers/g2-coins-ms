package com.co.indra.coinmarketcap.coins.model.responses;

import java.io.Serializable;

public class CoinApiExternalSummary implements Serializable {
    private CoinAPIExternal data;
    private  Double timestamp;

    public CoinApiExternalSummary() {
    }

    public CoinApiExternalSummary(CoinAPIExternal data, Double timestamp){
        this.data = data;
        this.timestamp = timestamp;
    }

    public CoinAPIExternal getData() {
        return data;
    }

    public void setData(CoinAPIExternal data) {
        this.data = data;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
}
