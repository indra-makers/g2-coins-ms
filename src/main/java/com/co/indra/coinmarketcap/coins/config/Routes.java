package com.co.indra.coinmarketcap.coins.config;

public class Routes {

    public static final String COINS_PATH = "/coins";
    public static final String COINS_WITH_IDSIMBOLCOIN_PATH = "/coins/{{idSymbolCoin}}";

    public static final String COINS_HISTORY_PATH = COINS_PATH + "/history";
    public static final String COINS_HISTORY_WITH_IDSYMBOLCOIN_PATH = COINS_PATH + "/history/{{idSymbolCoin}}";

    public static final String CATEGORY_PATH = "/category";
    public static final String CATEGORY_WITH_IDCATEGORY_PATH = "/category/{{idCategory}}";
    public static final String ADD_COIN_TO_CATEGORY_PATH = CATEGORY_WITH_IDCATEGORY_PATH + "/coins/{{idSymbolCoin}}";
}
