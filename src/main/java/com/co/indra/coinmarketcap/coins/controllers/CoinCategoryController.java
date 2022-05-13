package com.co.indra.coinmarketcap.coins.controllers;

import com.co.indra.coinmarketcap.coins.services.CoinCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinCategoryController {
    @Autowired
    private CoinCategoryService coinCategoryService;
}
