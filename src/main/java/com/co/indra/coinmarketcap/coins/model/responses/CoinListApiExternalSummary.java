package com.co.indra.coinmarketcap.coins.model.responses;

import java.io.Serializable;
import java.util.List;

public class CoinListApiExternalSummary implements Serializable {
    private List<CoinAPIExternal> data;
    private  Double timestamp;

    public CoinListApiExternalSummary() {
    }

    public CoinListApiExternalSummary(List<CoinAPIExternal> data, Double timestamp){
        this.data = data;
        this.timestamp = timestamp;
    }

    public List<CoinAPIExternal> getData() {
        return data;
    }

    public void setData(List<CoinAPIExternal> data) {
        this.data = data;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
}
