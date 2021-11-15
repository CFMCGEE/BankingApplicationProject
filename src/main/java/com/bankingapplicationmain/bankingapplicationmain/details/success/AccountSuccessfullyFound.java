package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;

import java.util.List;

public class AccountSuccessfullyFound {

    private Integer code;
    private String message;
    private List<Account> data;

    public AccountSuccessfullyFound(Integer code, String message, List<Account> data) {

        this.code = code;
        this.message = message;
        this.data = data;

    }

    public AccountSuccessfullyFound() {

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

    public List<Account> getData() {
        return data;
    }

    public void setData(List<Account> data) {
        this.data = data;
    }

}
