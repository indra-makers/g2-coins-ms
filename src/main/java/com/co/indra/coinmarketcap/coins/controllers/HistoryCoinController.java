package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.services.HistoryCoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryCoinController {
    @Autowired
    private HistoryCoinService historyCoinService;
}
