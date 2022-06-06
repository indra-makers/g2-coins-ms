package com.co.indra.coinmarketcap.coins.apiExterna.service;


import com.co.indra.coinmarketcap.coins.apiExterna.clientes.CoinCapApiClient;
import com.co.indra.coinmarketcap.coins.apiExterna.models.CoinApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinApiService {

    @Autowired
    private CoinCapApiClient coinCapApiClient;

    // prueba
    /*public CoinApi obtenerCoin(String symbol){
        return new CoinApi("ETH","bit-coin","BTCicono");
    }*/

    public CoinApi obtenerCoin(String symbol){
        return coinCapApiClient.getCoin(symbol);
    }
}
