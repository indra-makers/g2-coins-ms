create table public.tbl_historyCoins(
    id_historyCoin serial primary key,
    id_symbolCoinFK varchar(255) NOT NULL,
    actualPrice numeric NOT NULL,
    variation24h numeric NOT NULL,
    variation7d numeric NOT NULL,
    marketCap numeric NOT NULL,
    volume24h numeric NOT NULL,
    circulatingSupply numeric NOT NULL,
    CONSTRAINT id_symbolCoin_FK FOREIGN KEY (id_symbolCoinFK) REFERENCES tbl_coins(id_symbolCoin)
)