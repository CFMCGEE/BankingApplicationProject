package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Bill;
import java.util.List;

public class BillSuccessfullyFound {

    private Integer code;
    private String message;
    private List<Bill> data;

    public BillSuccessfullyFound(Integer code, String message, List<Bill> data) {

        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BillSuccessfullyFound() {
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

    public List<Bill> getData() {
        return data;
    }

    public void setData(List<Bill> data) {
        this.data = data;
    }

}