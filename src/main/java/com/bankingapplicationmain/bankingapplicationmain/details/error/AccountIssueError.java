package com.bankingapplicationmain.bankingapplicationmain.details.error;

public class AccountIssueError {

    private Integer code;
    private String message;

    public AccountIssueError(Integer code, String message) {

        this.code = code;
        this.message = message;

    }

    public AccountIssueError() {

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


