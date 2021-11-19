package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;
import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;

public class DepositSuccessfullyCreated {
    private Integer code;
    private String message;
    private Deposits data;

    public DepositSuccessfullyCreated(Integer code, String message, Deposits data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DepositSuccessfullyCreated() {
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

    public Deposits getData() {
        return data;
    }

    public void setData(Deposits data) {
        this.data = data;
    }
}
