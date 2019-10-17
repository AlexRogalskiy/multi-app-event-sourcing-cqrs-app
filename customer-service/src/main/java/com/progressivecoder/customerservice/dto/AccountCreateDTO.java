package com.progressivecoder.customerservice.dto;

import java.math.BigDecimal;

public class AccountCreateDTO {

    private BigDecimal startingBalance;

    private String currency;

    public BigDecimal getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
