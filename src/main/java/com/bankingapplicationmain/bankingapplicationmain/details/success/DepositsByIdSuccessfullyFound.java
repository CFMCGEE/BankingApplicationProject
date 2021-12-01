package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;

public class DepositsByIdSuccessfullyFound {

    private Integer code;
    private String message;
    private Iterable<Deposits> data;

    public DepositsByIdSuccessfullyFound(Integer code, String message, Iterable<Deposits> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DepositsByIdSuccessfullyFound() {
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

    public Iterable<Deposits> getData() {
        return data;
    }

    public void setData(Iterable<Deposits> data) {
        this.data = data;
    }
}
