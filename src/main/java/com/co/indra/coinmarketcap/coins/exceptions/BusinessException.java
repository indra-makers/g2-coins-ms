package com.co.indra.coinmarketcap.coins.exceptions;

import com.co.indra.coinmarketcap.coins.config.ErrorCodes;

public class BusinessException extends RuntimeException {
    private ErrorCodes code;
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(ErrorCodes code) {
        super(code.getMessage());
        this.code = code;
    }

    public String getCode() {
        return code.getCode();
    }
}
