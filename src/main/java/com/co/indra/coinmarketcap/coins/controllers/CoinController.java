package com.co.indra.coinmarketcap.coins.controllers;

<<<<<<< Updated upstream
import com.co.indra.coinmarketcap.coins.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController {
    @Autowired
    private CoinService coinService;
=======
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/coins")
public class CoinController {
    @Autowired
    private CoinService coinService;

    @PostMapping
    public void create(@Valid @RequestBody Coin coin) {
        coinService.registerCoin(coin.getIdSymbolCoin(), coin.getNameCoin(), coin.getIconCoin());
    }

    @GetMapping
    public List<Coin> getDeviceMeasures() {
        return coinService.listAllCoins();
    }
>>>>>>> Stashed changes
}
