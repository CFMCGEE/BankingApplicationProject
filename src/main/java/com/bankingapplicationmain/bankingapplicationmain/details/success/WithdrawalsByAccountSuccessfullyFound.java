package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;

import java.util.List;

public class WithdrawalsByAccountSuccessfullyFound {

    private Integer code;
    private List<Account> data;

    public WithdrawalsByAccountSuccessfullyFound(Integer code, List<Account> data) {

        this.code = code;
        this.data = data;

    }

    public WithdrawalsByAccountSuccessfullyFound() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Account> getData() {
        return data;
    }

    public void setData(List<Account> data) {
        this.data = data;
    }

}
