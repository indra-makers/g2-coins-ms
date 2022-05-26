package com.co.indra.coinmarketcap.coins.RestApiClient;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TemplateCoin {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RestService restService;

    @Autowired
    private CoinRepository coinRepository;

    public void agregarMoneda(String nombreMoneda){
        coinRepository.create(restService.getCoinWithResponseHandling(nombreMoneda));
    }

}
