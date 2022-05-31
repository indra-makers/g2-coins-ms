package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.config.Routes;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.responses.CoinApiResponse;
import com.co.indra.coinmarketcap.coins.model.responses.CoinListApi;
import com.co.indra.coinmarketcap.coins.repositories.CoinApiRepository;
import com.co.indra.coinmarketcap.coins.services.CoinService;
import com.co.indra.coinmarketcap.coins.services.CoinApiService;
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

    @Autowired
    private CoinApiService coinApiService;

    @Autowired
    private CoinApiRepository coinApiRepository;

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

    /**
     * http://localhost:8081/api/coins/{idSymbolCoin}
     * GET coins/{idSymbolCoin}
     */
    @GetMapping(Routes.ID_SYMBOLCOIN_PATH)
    public Coin getCoinByIdSymbolCoin(
            @PathVariable("idSymbolCoin") String idSymbolCoin) {
        return coinApiRepository.getCoinByIdSymbolCoin(idSymbolCoin);
    }

    @GetMapping(Routes.GET_ALL_COINS_API)
    public CoinListApi getCoinsExternal(){
        return coinApiRepository.getCoinsExternal();
    }


}
