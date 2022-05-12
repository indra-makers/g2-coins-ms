create table public.tb_coinCategory(
    idSymbolCoinFK varchar(255) NOT NULL,
    idCategoryFK INT NOT NULL,
    CONSTRAINT idSymbolCoin_FK FOREIGN KEY (idSymbolCoinFK) REFERENCES tb_coin(idSymbolCoin),
    CONSTRAINT idCategory_FK FOREIGN KEY (idCategoryFK) REFERENCES tb_category(idCategory)
)