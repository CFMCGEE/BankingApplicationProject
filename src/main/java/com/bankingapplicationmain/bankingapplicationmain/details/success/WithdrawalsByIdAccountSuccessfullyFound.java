package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;

import java.util.List;

public class WithdrawalsByIdAccountSuccessfullyFound {

    private Integer code;
    private Withdrawals data;

    public WithdrawalsByIdAccountSuccessfullyFound(Integer code, Withdrawals data) {

        this.code = code;
        this.data = data;

    }

    public WithdrawalsByIdAccountSuccessfullyFound() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Withdrawals getData() {
        return data;
    }

    public void setData(Withdrawals data) {
        this.data = data;
    }

}
