package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.config.Routes;
import com.co.indra.coinmarketcap.coins.externalApi.CoinApiClient;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Routes.COINS_PATH)
public class CoinController {
    @Autowired
    private CoinService coinService;

    /**
     * http://localhost:8435/api/coins
     *   POST /api/coins
     * @param
     * @return 200 OK
     */
    @PostMapping
    public void create(@Valid @RequestBody Coin coin) {
        coinService.registerCoin(coin.getIdSymbolCoin(), coin.getNameCoin(), coin.getIconCoin());
    }

    /**
     * http://localhost:8435/api/coins
     *   GET /api/coins
     * @param
     * @return Page of all coins in DB
     */
    @GetMapping
    public Page<Coin> getAllCoinsPaged(@PageableDefault(page=0, size=2) Pageable pageable){
        return (Page<Coin>) coinService.findAllCoinsPaged((Pageable) pageable);
    }

    @GetMapping(Routes.COIN_CAP)
    public List<Coin> getAllCoins(){
        return coinService.getAllCoins();
    }

    @GetMapping(Routes.COIN_CAP+Routes.GET_COIN_CAP_BY_SYMBOL)
    public Coin getCoinBySymbol(@PathVariable ("idSymbolCoin") String id){
        return coinService.getCoinBySymbol(id);
    }

}
