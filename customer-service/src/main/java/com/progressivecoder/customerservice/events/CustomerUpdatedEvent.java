package com.progressivecoder.customerservice.events;

public class CustomerUpdatedEvent {

    private final String customerId;

    public CustomerUpdatedEvent(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
