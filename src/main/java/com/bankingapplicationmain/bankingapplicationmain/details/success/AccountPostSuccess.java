package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;

public class AccountPostSuccess {
    private Integer code;
    private String message;
    private Account data;

    public AccountPostSuccess(Integer code, String message, Account data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public Account getData() {
        return data;
    }

    public void setData(Account data) {
        this.data = data;
    }
}
