package com.account.sorry.model;

public enum AccountType {

    consume("consume"),
    invest("invest"),
    wast("waste");

    private String value;

    AccountType(String value){
        this.value = value;
    }

    public String getKey(){
        return name();
    }

    public String getValue() {
        return value;
    }
}
