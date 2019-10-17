package com.progressivecoder.customerservice.events;

public class CustomerCreatedEvent {

    private final String customerId;

    public CustomerCreatedEvent(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
