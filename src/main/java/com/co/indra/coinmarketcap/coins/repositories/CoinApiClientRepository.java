package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.model.responses.CoinAPIExternal;
import com.co.indra.coinmarketcap.coins.model.responses.CoinApiExternalSummary;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinApiClientRepository {

    private final RestTemplate restTemplate;

    public CoinApiClientRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CoinApiExternalSummary getCoinInformationAPIExternalJSON(String id) {
        String url = "https://api.coincap.io/v2/assets/{id}";
        return this.restTemplate.getForObject(url, CoinApiExternalSummary.class, id);
    }
}
