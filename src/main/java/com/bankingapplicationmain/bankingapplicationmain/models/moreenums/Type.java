package com.bankingapplicationmain.bankingapplicationmain.models.moreenums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {

    @JsonProperty("P2P")
    P2P,
    @JsonProperty("Deposit")
    DEPOSIT,
    @JsonProperty("Withdrawal")
    WITHDRAWAL;

    Type() {

    }

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
