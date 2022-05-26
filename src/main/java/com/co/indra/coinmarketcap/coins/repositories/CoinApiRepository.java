package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.responses.CoinApiResponse;
import com.co.indra.coinmarketcap.coins.services.CoinApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoinApiRepository {
    @Autowired
    private CoinApiService coinApiService;

    @Autowired
    private CoinRepository coinRepository;



    public Coin getCoinByIdSymbolCoin(String idSymbolCoin) {
        if(coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).isEmpty()){
            throw new NotFoundException(ErrorCodes.ID_SYMBOLCOIN_NOT_EXIST.getMessage());
        }
        String nameCoin = coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).get(0).getNameCoin();

        CoinApiResponse coinApiResponse = coinApiService.getPostsPlainJSON(nameCoin);
        Coin coin = new Coin(coinApiResponse.getData().getSymbol(), coinApiResponse.getData().getName(), coinApiResponse.getData().getExplorer());
        return coin;


    }

}
