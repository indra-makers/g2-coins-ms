package com.co.indra.coinmarketcap.coins.RestApiClient.Model;

import java.util.List;

public class ListResponseBody {

    private List<CoinApiExterna> data;
    private Double timestamp;

    public ListResponseBody(List<CoinApiExterna> data, Double timestamp) {
        this.data = data;
        this.timestamp= timestamp;
    }

    public ListResponseBody(){

    }

    public List<CoinApiExterna> getData() {
        return data;
    }

    public void setData(List<CoinApiExterna> data) {
        this.data = data;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
}
