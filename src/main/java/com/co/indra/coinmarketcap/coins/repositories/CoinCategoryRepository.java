package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.model.entities.Category;
import com.co.indra.coinmarketcap.coins.model.entities.CoinCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

class CoinCategoryRowMapper implements RowMapper<CoinCategory> {
    @Override
    public CoinCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        CoinCategory coinCategory = new CoinCategory();
        coinCategory.setIdSymbolCoin(rs.getString("id_SymbolCoinFK"));
        coinCategory.setIdCategory(rs.getLong("id_CategoryFK"));
        return coinCategory;
    }
}
@Repository
public class CoinCategoryRepository {
    @Autowired
    private JdbcTemplate template;
}
