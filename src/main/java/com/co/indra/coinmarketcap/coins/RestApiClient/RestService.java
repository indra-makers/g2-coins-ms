package com.co.indra.coinmarketcap.coins.RestApiClient;

import com.co.indra.coinmarketcap.coins.RestApiClient.Model.CoinApiExterna;
import com.co.indra.coinmarketcap.coins.RestApiClient.Model.Data;
import com.co.indra.coinmarketcap.coins.RestApiClient.Model.ListResponseBody;
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


        public Data getCoinWithResponseHandling(String symbol) {
            String url = "https://api.coincap.io/v2/assets/{symbol}";
            ResponseEntity<Data> response = this.restTemplate.getForEntity(url, Data.class, symbol);
            if(response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                return null;
            }
        }

    public ListResponseBody getListResponseBodyWithResponseHandling() {
        String url = "https://api.coincap.io/v2/assets";
        ResponseEntity<ListResponseBody> response = this.restTemplate.getForEntity(url, ListResponseBody.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

    public Coin getCoinWithResponseHandlingBySymbol(String symbol) {
        String url = "https://api.coincap.io/v2/assets/{symbol}";
        ResponseEntity<Data> response = this.restTemplate.getForEntity(url, Data.class, symbol);
        if(response.getStatusCode() == HttpStatus.OK) {
            return new Coin(response.getBody().getData().getSymbol(), response.getBody().getData().getName(),
                            response.getBody().getData().getExplorer()) ;
        } else {
            return null;
        }
    }



}
