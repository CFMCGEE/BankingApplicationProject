package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;

import java.util.List;

public class DepositSuccessfullyUpdated {

    private Integer code;
    private String message;


    public DepositSuccessfullyUpdated(Integer code, String message, Deposits data) {
        this.code = code;
        this.message = message;
    }

    public DepositSuccessfullyUpdated() {
    }

    public DepositSuccessfullyUpdated(Integer code, String message) {
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
