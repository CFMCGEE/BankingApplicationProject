package com.bankingapplicationmain.bankingapplicationmain.details.success;

public class AccountSuccessfulMethods {

    private Integer code;
    private String message;

    public AccountSuccessfulMethods(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
