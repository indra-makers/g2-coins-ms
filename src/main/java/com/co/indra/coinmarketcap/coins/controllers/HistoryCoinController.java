package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.config.Routes;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.entities.HistoryCoin;
import com.co.indra.coinmarketcap.coins.services.HistoryCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.HISTORY_COINS)
public class HistoryCoinController {
    @Autowired
    private HistoryCoinService historyCoinService;

    /**
     * http://localhost:8435/api/historyCoins/{idSymbolCoinFK}
     *   GET /api/coins
     * @param
     * @return Page of all coins in DB
     */
    @GetMapping(Routes.GET_HISTORY_COIN)
    public Page<HistoryCoin> getAllHistoryCoinsPaged(@PageableDefault(page=0, size=2) Pageable pageable, @PathVariable ("id_symbolCoinFK") String idSymbolCoin ){
        return (Page<HistoryCoin>) historyCoinService.findAllHistoryCoinsPaged((Pageable) pageable, idSymbolCoin);
    }


}
