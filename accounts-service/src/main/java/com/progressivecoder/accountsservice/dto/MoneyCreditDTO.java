package com.progressivecoder.accountsservice.dto;

import java.math.BigDecimal;

public class MoneyCreditDTO {

    private BigDecimal creditAmount;

    private String currency;

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
