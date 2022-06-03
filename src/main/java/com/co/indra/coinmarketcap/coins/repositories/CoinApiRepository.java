package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.entities.CoinApi;
import com.co.indra.coinmarketcap.coins.model.responses.CoinApiResponse;
import com.co.indra.coinmarketcap.coins.model.responses.CoinListApi;
import com.co.indra.coinmarketcap.coins.services.CoinApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CoinApiRepository {
    @Autowired
    private CoinApiService coinApiService;

    @Autowired
    private CoinRepository coinRepository;

    public static Map<String, String> mapSymbol = new HashMap<String, String>();

    @PostConstruct
    public void getNameCoin(){
        CoinListApi coinListApiExternalSummary = coinApiService.getAllCoins();
        for (CoinApi coin : coinListApiExternalSummary.getData()){
            mapSymbol.put(coin.getSymbol(), coin.getId());
        }

    }

    public CoinListApi getCoinsExternal() {
        return coinApiService.getAllCoins();
    }
    public Coin getCoinByIdSymbolCoin(String idSymbolCoin) {

        if(coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).isEmpty()){
            throw new NotFoundException(ErrorCodes.ID_SYMBOLCOIN_NOT_EXIST.getMessage());
        }

        CoinApiResponse coinApiResponse = coinApiService.getPostsPlainJSON(mapSymbol.get(idSymbolCoin));
        Coin coin = new Coin(coinApiResponse.getData().getSymbol(), coinApiResponse.getData().getName(), coinApiResponse.getData().getExplorer());
        return coin;


    }


}
