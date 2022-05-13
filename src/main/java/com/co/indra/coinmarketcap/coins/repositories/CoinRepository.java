package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public void create(Coin coin) {
        template.update("INSERT INTO tbl_coins(id_symbolCoin, nameCoin, iconCoin) values(?,?,?)",
                coin.getIdSymbolCoin(), coin.getNameCoin(), coin.getIconCoin());
    }

    public List<Coin> findCoinByIdSymbolCoin(String idSymbolCoin) {
        return template.query(
                "SELECT id_symbolCoin, nameCoin, iconCoin FROM tbl_coins WHERE id_symbolCoin=?",
                new CoinRowMapper(),
                idSymbolCoin);
    }

    public List<Coin> listAllCoins() {
        return template.query(
                "SELECT id_symbolCoin, nameCoin, iconCoin FROM tbl_coins",
                new CoinRowMapper());
    }

    public Page<Coin> listAllCoinsWithPage(Pageable pageable){
        return (Page<Coin>) listAllCoins();
    }



}
