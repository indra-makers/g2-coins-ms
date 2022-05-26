package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.RestApiClient.CoinApiExterna;
import com.co.indra.coinmarketcap.coins.RestApiClient.RestService;
import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.BusinessException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private RestService restService;

    public void registerCoin(String idSymbolCoin, String nameCoin, String iconCoin) {
        if(!coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).isEmpty()) {
            throw new BusinessException(ErrorCodes.ID_SYMBOLCOIN_ALREDY_EXIST);
        }
        coinRepository.create(new Coin(idSymbolCoin, nameCoin, iconCoin));
    }

    public List<Coin> listAllCoins() {
        return coinRepository.listAllCoins();
    }

    public Page<Coin> findAllCoinsPaged(Pageable pageable) {
        Page<Coin> coin = coinRepository.findAllCoinsPaged(pageable);
        return coin;
    }

    public CoinApiExterna findCoinBySymbol(String symbol){
        CoinApiExterna coinApiExterna = restService.getCoinWithResponseHandling(symbol);
        return coinApiExterna;
    }

}
