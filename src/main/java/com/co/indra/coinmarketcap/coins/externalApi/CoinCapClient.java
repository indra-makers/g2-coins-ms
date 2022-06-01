package com.co.indra.coinmarketcap.coins.externalApi;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CoinCapClient {

    private Map<String, String> MapCoins = new HashMap<>();

    private final RestTemplate restTemplate;

    @PostConstruct
    public void addCoinsMap(){
        CoinApiClientAssets coinApiClientAssets = getPostsPlainJSON();
        for(CoinApi x: coinApiClientAssets.getData()){
           MapCoins.put(x.getSymbol(), x.getId());
        }
    }



    public CoinCapClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CoinApiClientAssets getPostsPlainJSON() {
        String url = "https://api.coincap.io/v2/assets";
        return this.restTemplate.getForObject(url, CoinApiClientAssets.class);
    }

    public CoinApiClientAsset getPostsPlainJSONByAsset(String symbol) {
        String url = "https://api.coincap.io/v2/assets/" + MapCoins.get(symbol);
        return this.restTemplate.getForObject(url, CoinApiClientAsset.class);
    }


}
