package com.bankingapplicationmain.bankingapplicationmain.details.success;

import com.bankingapplicationmain.bankingapplicationmain.models.Customer;

public class CustomerFoundById {


    private Integer code;
    private String message;
    private int customer_id;

    public CustomerFoundById() {
    }

    public CustomerFoundById(Integer code, String message, int customer_id) {
        this.code = code;
        this.message = message;
        this.customer_id = customer_id;
    }

    public CustomerFoundById(Integer code, String message) {
        this.code = code;
        this.message = message;
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }




}
