package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.RestApiClient.Model.CoinApiExterna;
import com.co.indra.coinmarketcap.coins.RestApiClient.Model.Data;
import com.co.indra.coinmarketcap.coins.RestApiClient.Model.ListResponseBody;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/coins")
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
    public Page<Coin> getAllCoinsPaged(@PageableDefault(page=1, size=2) Pageable pageable){
        return (Page<Coin>) coinService.findAllCoinsPaged((Pageable) pageable);
    }


    @GetMapping("/{symbol}")
    public Data getCoinBySymbolCoin(
            @PathVariable("symbol") String symbol) {
        return coinService.findCoinBySymbol(symbol);
    }

    @GetMapping("/responseBody")
    public ListResponseBody getResponseBody() {
        return coinService.getResponseBody();
    }

    @GetMapping("/CoinBySymbol/{symbol}")
    public Coin getCoinBySymbol(@PathVariable("symbol") String symbol) {
        return coinService.getCoinInListOfCoins(symbol);
    }



}
