package com.bankingapplicationmain.bankingapplicationmain.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("pending")
    PENDING,
    @JsonProperty("cancelled")
    CANCELLED,
    @JsonProperty("completed")
    COMPLETED,
    @JsonProperty("recurring")
    RECURRING;

    private String status;

    Status() {

    }

    Status(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }
}
