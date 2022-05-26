package com.co.indra.coinmarketcap.coins.config;

public class Routes {
    public static final String COINS_PATH = "/coins";

    public static final String HISTORY_COINS = "/historyCoins";

    public static final String GET_HISTORY_COIN = "/{id_symbolCoinFK}";

    public static final String PAGEABLE= "?page=0&size=2";

    public static final String COIN_CAP= "/coinCap";

    public static final String GET_COIN_CAP_BY_SYMBOL= "/{idSymbolCoin}";

}
