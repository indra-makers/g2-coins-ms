package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController {
    @Autowired
    private CoinService coinService;
}
