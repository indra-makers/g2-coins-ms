package com.co.indra.coinmarketcap.coins.services;

<<<<<<< Updated upstream
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
import com.co.indra.coinmarketcap.coins.config.ErrorCodes;
import com.co.indra.coinmarketcap.coins.exceptions.BusinessException;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

>>>>>>> Stashed changes
@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;
<<<<<<< Updated upstream
=======

    public void registerCoin(String idSymbolCoin, String nameCoin, String iconCoin) {
        if(coinRepository.findCoinByIdSymbolCoin(idSymbolCoin).size() == 0) {
            coinRepository.create(new Coin(idSymbolCoin, nameCoin, iconCoin));
        }
        else{
            throw new BusinessException(ErrorCodes.ID_SYMBOLCOIN_ALREDY_EXIST);
        }
    }

    public List<Coin> listAllCoins() {
        return coinRepository.listAllCoins();
    }

    public Page<Coin> listAllCoinsWithPage(Pageable pageable) {
        Page<Coin> coin = coinRepository.listAllCoinsWithPage(pageable);
        return coin;
    }

>>>>>>> Stashed changes
}
