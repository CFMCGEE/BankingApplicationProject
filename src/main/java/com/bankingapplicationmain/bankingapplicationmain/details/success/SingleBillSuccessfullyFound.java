package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;

public class SingleBillSuccessfullyFound {
    private Integer code;
    private String message;
    private Bill data;

    public SingleBillSuccessfullyFound(Integer code, String message, Bill data) {
        this.code = code;
        this.message = message;
        this.data = data;

    }

    public SingleBillSuccessfullyFound() {

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

    public Bill getData() {
        return data;
    }

    public void setData(Bill data) {
        this.data = data;
    }
}
