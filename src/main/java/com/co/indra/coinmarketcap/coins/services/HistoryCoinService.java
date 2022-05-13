package com.co.indra.coinmarketcap.coins.services;

import com.co.indra.coinmarketcap.coins.repositories.HistoryCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryCoinService {
    @Autowired
    private HistoryCoinRepository historyCoinRepository;
}
