package com.co.indra.coinmarketcap.coins.config;

public enum ErrorCodes {
    ID_SYMBOLCOIN_NOT_EXIST("Symbol Coin not exist", "001"),
    ID_SYMBOLCOIN_ALREDY_EXIST("Symbol Coin alredy exist", "002"),
    INVALID_ID_DEVICE("Invalid category", "003"),
    NOT_HISTORY_OF_COIN("Not history of that coin", "004"),
    ID_SYMBOLCOIN_NOT_FOUND("idSymbolCoin not found", "005");


    String message;
    String code;

    ErrorCodes(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
