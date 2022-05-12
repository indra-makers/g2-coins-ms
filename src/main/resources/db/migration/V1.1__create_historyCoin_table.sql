create table public.tb_historyCoin(
    idHistoryCoin serial primary key,
    idSymbolCoinFK varchar(255) NOT NULL,
    actualPrice numeric NOT NULL,
    variation24h numeric NOT NULL,
    variation7d numeric NOT NULL,
    marketCap numeric NOT NULL,
    volume24h numeric NOT NULL,
    circulatingSupply numeric NOT NULL,
    CONSTRAINT idSymbolCoin_FK FOREIGN KEY (idSymbolCoinFK) REFERENCES tb_coin(idSymbolCoin)
)