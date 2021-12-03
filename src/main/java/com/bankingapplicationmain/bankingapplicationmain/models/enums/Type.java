package com.bankingapplicationmain.bankingapplicationmain.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Type {

    @JsonProperty("Savings")
    SAVINGS,
    @JsonProperty("Checkings")
    CHECKINGS,
    @JsonProperty("Credit")
    CREDIT,
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
