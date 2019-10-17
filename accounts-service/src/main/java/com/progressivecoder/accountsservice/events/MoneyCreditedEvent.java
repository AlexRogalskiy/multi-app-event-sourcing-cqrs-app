package com.progressivecoder.accountsservice.events;

import java.math.BigDecimal;

public class MoneyCreditedEvent extends BaseEvent<String> {

    public final BigDecimal creditAmount;

    public final String currency;

    public MoneyCreditedEvent(String id, BigDecimal creditAmount, String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
