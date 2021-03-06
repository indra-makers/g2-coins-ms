package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.config.Routes;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.responses.CoinListApiExternalSummary;
import com.co.indra.coinmarketcap.coins.services.CoinApiClientService;
import com.co.indra.coinmarketcap.coins.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(Routes.COINS_PATH)
public class CoinController {
    @Autowired
    private CoinService coinService;
    @Autowired
    private CoinApiClientService coinApiClientService;

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

    /**
     * http://localhost:8082/api/coins-ms/coins/{idSimbolCoin}
     * GET /api/coins-ms/coins/{idSimbolCoin}
     */
    @GetMapping(Routes.ID_COINS_PATH)
    public Coin getCoinInformationAPIExternal(@PathVariable("idSymbolCoin") String idSymbolCoin) {
        return coinApiClientService.getCoinInformationAPIExternal(idSymbolCoin);
    }

    /**
     * http://localhost:8082/api/coins-ms/coins/getAllCoinsAPIExternal
     * GET /api/coins-ms/coins/getAllCoinsAPIExternal
     */
    @GetMapping(Routes.GET_ALL_COINS_APIEXTERNAL)
    public CoinListApiExternalSummary getCoinsExternal(){
        return coinApiClientService.getCoinsExternal();
    }
}
