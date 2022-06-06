package com.co.indra.coinmarketcap.coins.apiExterna.clientes;

import com.co.indra.coinmarketcap.coins.apiExterna.models.CoinApi;
import com.co.indra.coinmarketcap.coins.apiExterna.models.coincap.CoinCapResponse;
import com.co.indra.coinmarketcap.coins.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CoinCapApiClient {

    @Autowired
    private RestTemplate restTemplate;


    //api.coincap.io/v2/assets/bitcoin
    public CoinApi getCoin(String symbol){

        UriComponentsBuilder uri = UriComponentsBuilder
                                    .fromUriString("https://api.coincap.io/v2/assets/")
                                    .queryParam("symbol", symbol);
        ResponseEntity<CoinCapResponse> response = restTemplate.getForEntity(uri.toUriString(), CoinCapResponse.class);

        if(!(response.getStatusCode() == HttpStatus.OK)) {
            throw new BusinessException("API ERROR");
        }

        CoinCapResponse body = response.getBody();
        return new CoinApi( body.getCoincapData().getSymbol(), body.getCoincapData().getName(), body.getCoincapData().getIcono());


    }

}
