package com.bankingapplicationmain.bankingapplicationmain.details.error;

public class NotFoundError {

    private Integer code;
    private String message;

    public NotFoundError(Integer code, String message) {

        this.code = code;
        this.message = message;

    }

    public NotFoundError() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}


