package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.model.responses.CoinApiResponse;
import com.co.indra.coinmarketcap.coins.model.responses.CoinListApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinApiService {

    private final RestTemplate restTemplate;

    public CoinApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CoinListApi getAllCoins() {
        String url = "https://api.coincap.io/v2/assets";
        return this.restTemplate.getForObject(url, CoinListApi.class);
    }

    public CoinApiResponse getPostsPlainJSON(String idSymbolCoin) {
        String url = "https://api.coincap.io/v2/assets/" + idSymbolCoin;
        return this.restTemplate.getForObject(url, CoinApiResponse.class);

    }



}
