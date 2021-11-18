package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;

import java.util.List;

public class WithdrawalsByAccountSuccessfullyFound {

    private Integer code;
    private List<Withdrawals> data;

    public WithdrawalsByAccountSuccessfullyFound(Integer code, List<Withdrawals> data) {

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

    public List<Withdrawals> getData() {
        return data;
    }

    public void setData(List<Withdrawals> data) {
        this.data = data;
    }

}
