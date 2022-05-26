package com.co.indra.coinmarketcap.coins.RestApiClient;

import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


        public CoinApiExterna getCoinWithResponseHandling(String symbol) {
            String url = "https://api.coincap.io/v2/assets/{nombreMoneda}";
            ResponseEntity<CoinApiExterna> response = this.restTemplate.getForEntity(url, CoinApiExterna.class, symbol);
            if(response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                return null;
            }
        }

}
