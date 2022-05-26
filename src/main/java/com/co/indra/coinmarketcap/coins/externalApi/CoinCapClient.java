package com.co.indra.coinmarketcap.coins.externalApi;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CoinCapClient {

    private final RestTemplate restTemplate;

    public CoinCapClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CoinApiClient getPostsPlainJSON() {
        String url = "https://api.coincap.io/v2/assets";
        return this.restTemplate.getForObject(url, CoinApiClient.class);
    }

}
