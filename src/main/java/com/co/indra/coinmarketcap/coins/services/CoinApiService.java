package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.model.responses.CoinApiResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinApiService {

    private final RestTemplate restTemplate;

    public CoinApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CoinApiResponse getPostsPlainJSON(String id) {
        String url = "https://api.coincap.io/v2/assets/{id}";
        return this.restTemplate.getForObject(url, CoinApiResponse.class, id);

    }

}
