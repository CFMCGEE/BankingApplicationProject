package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;

import java.util.List;

public class CustomersSuccessfullyFound {

    private Integer code;
    private String message;
    private List<Customer> data;

    public CustomersSuccessfullyFound(Integer code, String message, List<Customer> data) {

        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CustomersSuccessfullyFound() {

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

    public List<Customer> getData() {
        return data;
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }

}
