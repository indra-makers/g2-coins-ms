package com.co.indra.coinmarketcap.coins.repositories;

import com.co.indra.coinmarketcap.coins.model.entities.Category;
import com.co.indra.coinmarketcap.coins.model.entities.Coin;
import com.co.indra.coinmarketcap.coins.model.entities.HistoryCoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public HistoryCoin mapHistoryCoinResult(final ResultSet rs) throws SQLException {
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


    public List<HistoryCoin> findHistoryCoinByIdSymbolCoin(String idSymbolCoin) {
        return template.query(
                "SELECT id_historycoin, id_symbolcoinfk, actualprice, variation24h, variation7d, marketcap, volume24h, circulatingsupply\n" +
                        "FROM public.tbl_historycoins WHERE id_symbolcoinfk=?",
                new HistoryCoinRowMapper(),
                idSymbolCoin);
    }

    public List<HistoryCoin> listAllHistoryCoins() {
        return template.query("SELECT id_historycoin, id_symbolcoinfk, actualprice, variation24h, variation7d, marketcap, volume24h, circulatingsupply\n" +
                        "FROM public.tbl_historycoins",
                new HistoryCoinRowMapper());
    }

    public int count(String idSymbolCoin) {
        return template.queryForObject("SELECT count(*) FROM tbl_historycoins WHERE id_symbolCoinFK=?", Integer.class, idSymbolCoin);
    }
    public Page<HistoryCoin> findHistoryCoinsPaged(Pageable pageable, String idSymbolCoin){
        Sort.Order order = !pageable.getSort().isEmpty() ? pageable.getSort().toList().get(0) : Sort.Order.by("id_symbolCoinFK");
        List<HistoryCoin> historyCoins = template.query("SELECT id_historycoin, id_symbolcoinfk, actualprice, variation24h, variation7d, marketcap, volume24h, circulatingsupply FROM tbl_historycoins WHERE id_symbolCoinFK=? ORDER BY "
                        + order.getProperty() + " " + order.getDirection().name()
                        + " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset(),
                (rs, rowNum) -> mapHistoryCoinResult(rs), idSymbolCoin);
        return new PageImpl<HistoryCoin>(historyCoins, pageable, count(idSymbolCoin));
    }




}
