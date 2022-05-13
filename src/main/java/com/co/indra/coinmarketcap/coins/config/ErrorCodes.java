package com.co.indra.coinmarketcap.coins.config;

public enum ErrorCodes {
    ID_SYMBOLCOIN_NOT_EXIST("Symbol Coin not exist", "001"),
<<<<<<< Updated upstream
    INVALID_ID_DEVICE("Invalid category", "002");
=======
    ID_SYMBOLCOIN_ALREDY_EXIST("Symbol Coin alredy exist", "002"),
    INVALID_ID_DEVICE("Invalid category", "003");
>>>>>>> Stashed changes
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
