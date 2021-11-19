package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Deposits;

import java.util.List;

public class DepositSuccessfullyUpdated {

    private Integer code;
    private String message;
    private List<Deposits> data;

    public DepositSuccessfullyUpdated(Integer code, String message, List<Deposits> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public DepositSuccessfullyUpdated() {
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

    public List<Deposits> getData() {
        return data;
    }

    public void setData(List<Deposits> data) {
        this.data = data;
    }
}
