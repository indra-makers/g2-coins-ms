package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.model.entities.Category;
import com.co.indra.coinmarketcap.coins.model.entities.HistoryCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

class HistoryCoinRowMapper implements RowMapper<HistoryCoin> {
    @Override
    public HistoryCoin mapRow(ResultSet rs, int rowNum) throws SQLException {
        HistoryCoin historyCoin = new HistoryCoin();
        historyCoin.setIdHistoryCoin(rs.getLong("id_HistoryCoin"));
        historyCoin.setIdSymbolCoin(rs.getString("id_SymbolCoinFK"));
        historyCoin.setActualPrice(rs.getLong("actualPrice"));
        historyCoin.setVariation24h(rs.getLong("variation24h"));
        historyCoin.setVariation7d(rs.getLong("variation7d"));
        historyCoin.setMarketCap(rs.getLong("marketCap"));
        historyCoin.setVolume24h(rs.getLong("volume24h"));
        historyCoin.setCirculatingSupply(rs.getLong("circulatingSupply"));
        return historyCoin;
    }
}
@Repository
public class HistoryCoinRepository {
    @Autowired
    private JdbcTemplate template;
}
