package com.progressivecoder.accountsservice.dto;

import java.math.BigDecimal;

public class MoneyDebitDTO {

    private BigDecimal debitAmount;

    private String currency;

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
