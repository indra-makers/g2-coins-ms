package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.BusinessException;
import com.co.indra.coinmarketcap.coins.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.responses.CoinAPIExternal;
import com.co.indra.coinmarketcap.coins.model.responses.CoinApiExternalSummary;
import com.co.indra.coinmarketcap.coins.model.responses.CoinListApiExternalSummary;
import com.co.indra.coinmarketcap.coins.repositories.CoinApiClientRepository;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CoinApiClientService {

    @Autowired
    private CoinApiClientRepository coinApiClientRepository;
    @Autowired
    private CoinRepository coinRepository;

    public static Map<String, String> coinsMap = new HashMap<String, String>();

    @PostConstruct
    public void getNameCoin(){
        CoinListApiExternalSummary coinListApiExternalSummary = coinApiClientRepository.getAllCoins();
        for (CoinAPIExternal coin : coinListApiExternalSummary.getData()){
            coinsMap.put(coin.getSymbol(),coin.getId());
        }
    }

    public CoinListApiExternalSummary getCoinsExternal() {
        return coinApiClientRepository.getAllCoins();
    }

    public Coin getCoinInformationAPIExternal(String idSymbolCoin){
        if(coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).isEmpty()) {
            throw new NotFoundException(ErrorCodes.ID_SYMBOLCOIN_NOT_FOUND.getMessage());
        }
        CoinApiExternalSummary coinApiExternalSummary = coinApiClientRepository.getCoinInformationAPIExternalJSON(coinsMap.get(idSymbolCoin));
        return new Coin(coinApiExternalSummary.getData().getSymbol(), coinApiExternalSummary.getData().getName(), coinApiExternalSummary.getData().getExplorer());
    }

    public Coin getCoinByName(String name){
        CoinApiExternalSummary coinApiExternalSummary=coinApiClientRepository.getCoinInformationAPIExternalJSON(name);
        return new Coin(coinApiExternalSummary.getData().getSymbol(), coinApiExternalSummary.getData().getName(), coinApiExternalSummary.getData().getExplorer());
    }
}
