package com.bankingapplicationmain.bankingapplicationmain.models.enums;

public enum Status {

    PENDING("Pending"), CANCELLED("Cancelled"), COMPLETED("Completed"), RECURRING("Recurring");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
