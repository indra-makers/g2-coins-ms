package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.model.entities.Category;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

class CoinRowMapper implements RowMapper<Coin> {
    @Override
    public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Coin coin = new Coin();
        coin.setIdSymbolCoin(rs.getString("id_symbolCoin"));
        coin.setNameCoin(rs.getString("nameCoin"));
        coin.setIconCoin(rs.getString("iconCoin"));
        return coin;
    }
}
@Repository
public class CoinRepository {
    @Autowired
    private JdbcTemplate template;
}
