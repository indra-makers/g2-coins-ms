package com.co.indra.coinmarketcap.coins.model.responses;

import com.co.indra.coinmarketcap.coins.model.entities.CoinApi;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class CoinListApi implements Serializable {

    private List<CoinApi> data;
    private  Double timestamp;

    public CoinListApi() {
    }

    public CoinListApi(List<CoinApi> data, Double timestamp){
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
