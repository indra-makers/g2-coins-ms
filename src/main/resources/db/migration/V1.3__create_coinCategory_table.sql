create table public.tbl_coinCategories(
    id_symbolCoinFK varchar(255) NOT NULL,
    id_categoryFK INT NOT NULL,
    CONSTRAINT id_symbolCoin_FK FOREIGN KEY (id_symbolCoinFK) REFERENCES tbl_coins(id_symbolCoin),
    CONSTRAINT id_category_FK FOREIGN KEY (id_categoryFK) REFERENCES tbl_categories(id_category)
)