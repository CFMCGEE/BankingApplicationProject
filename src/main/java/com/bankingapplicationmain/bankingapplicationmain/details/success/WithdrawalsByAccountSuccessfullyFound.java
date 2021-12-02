package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Account;
import com.bankingapplicationmain.bankingapplicationmain.models.Withdrawals;

import java.util.*;

public class WithdrawalsByAccountSuccessfullyFound {

    private Integer code;
    private Set<Withdrawals> data;

    public WithdrawalsByAccountSuccessfullyFound(Integer code, Set<Withdrawals> data) {

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

    public Set<Withdrawals> getData() {
        return data;
    }

    public void setData(Set<Withdrawals> data) {
        this.data = data;
    }

}
