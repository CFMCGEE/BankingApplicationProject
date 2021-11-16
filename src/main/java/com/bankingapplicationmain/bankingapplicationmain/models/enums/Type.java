package com.bankingapplicationmain.bankingapplicationmain.models.enums;

public enum Type {

    SAVINGS("Savings"), CHECKING("Checking"), CREDIT("Credit");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
