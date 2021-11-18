package com.bankingapplicationmain.bankingapplicationmain.models.moreenums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("Pending")
    PENDING,
    @JsonProperty("Cancelled")
    CANCELLED,
    @JsonProperty("Completed")
    COMPLETED,
    @JsonProperty("Executed")
    EXECUTED;

    Status() {

    }

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
