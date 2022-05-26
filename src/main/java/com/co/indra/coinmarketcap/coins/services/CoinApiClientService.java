package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.BusinessException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.responses.CoinAPIExternal;
import com.co.indra.coinmarketcap.coins.model.responses.CoinApiExternalSummary;
import com.co.indra.coinmarketcap.coins.repositories.CoinApiClientRepository;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoinApiClientService {

    @Autowired
    private CoinApiClientRepository coinApiClientRepository;
    @Autowired
    private CoinRepository coinRepository;

    public Coin getCoinInformationAPIExternal(String idSymbolCoin){
        if(coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).isEmpty()) {
            throw new BusinessException(ErrorCodes.ID_SYMBOLCOIN_NOT_EXIST);
        }
        String nameCoin = coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).get(0).getNameCoin();
        CoinApiExternalSummary coinApiExternalSummary = coinApiClientRepository.getCoinInformationAPIExternalJSON(nameCoin);
        return new Coin(coinApiExternalSummary.getData().getSymbol(), coinApiExternalSummary.getData().getName(), coinApiExternalSummary.getData().getExplorer());
    }
}
