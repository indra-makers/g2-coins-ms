package com.co.indra.coinmarketcap.coins.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryCoinRepository {
    @Autowired
    private JdbcTemplate template;
}
