package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;

import java.util.List;


public class CustomerSuccessfullyFound {

    private Integer code;
    private String message;
    private Customer data;

    public CustomerSuccessfullyFound() {

    }


    public CustomerSuccessfullyFound(Integer code, String message, Customer data) {
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

    public Customer getData() {
        return data;
    }

    public void setData(Customer data) {
        this.data = data;
    }
}
