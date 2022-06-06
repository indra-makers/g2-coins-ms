package com.co.indra.coinmarketcap.coins.apiExterna.models.coincap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinCapResponse {

    @JsonProperty("data")
    private coincapData coincapData;

    private Long timestamp;

    public CoinCapResponse() {
    }

    public CoinCapResponse(com.co.indra.coinmarketcap.coins.apiExterna.models.coincap.coincapData coincapData, Long timestamp) {
        this.coincapData = coincapData;
        this.timestamp = timestamp;
    }

    public com.co.indra.coinmarketcap.coins.apiExterna.models.coincap.coincapData getCoincapData() {
        return coincapData;
    }

    public void setCoincapData(com.co.indra.coinmarketcap.coins.apiExterna.models.coincap.coincapData coincapData) {
        this.coincapData = coincapData;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
