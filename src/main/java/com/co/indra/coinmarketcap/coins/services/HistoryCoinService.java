package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.BusinessException;
import com.co.indra.coinmarketcap.coins.exceptions.NotFoundException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.entities.HistoryCoin;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import com.co.indra.coinmarketcap.coins.repositories.HistoryCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryCoinService {
    @Autowired
    private HistoryCoinRepository historyCoinRepository;

    @Autowired
    private CoinRepository coinRepository;

    public List<HistoryCoin> listAllHistoryCoinsByCoin(String idSymbolCoin) {
        return historyCoinRepository.findHistoryCoinByIdSymbolCoin(idSymbolCoin);
    }

    public Page<HistoryCoin> findAllHistoryCoinsPaged(Pageable pageable, String idSymbolCoin) {
        if(coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).isEmpty()){
            throw new BusinessException(ErrorCodes.ID_SYMBOLCOIN_NOT_EXIST);
        }
        if(historyCoinRepository.findHistoryCoinByIdSymbolCoin(idSymbolCoin).isEmpty()){
            throw new BusinessException(ErrorCodes.NOT_HISTORY_OF_COIN);
        }


        Page<HistoryCoin> historyCoins = historyCoinRepository.findHistoryCoinsPaged(pageable, idSymbolCoin);
        return historyCoins;
    }
}
