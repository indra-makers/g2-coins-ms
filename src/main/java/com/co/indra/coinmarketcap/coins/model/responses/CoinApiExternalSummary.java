package com.co.indra.coinmarketcap.coins.model.responses;

import java.util.List;

public class CoinApiExternalSummary {
    private List<CoinAPIExternal> coinAPIExternalList;

    public CoinApiExternalSummary(List<CoinAPIExternal> coinAPIExternalList) {
        this.coinAPIExternalList = coinAPIExternalList;
    }

    public List<CoinAPIExternal> getCoinAPIExternal() {
        return coinAPIExternalList;
    }

    public void setCoinAPIExternal(List<CoinAPIExternal> coinAPIExternalList) {
        this.coinAPIExternalList = coinAPIExternalList;
    }
}
