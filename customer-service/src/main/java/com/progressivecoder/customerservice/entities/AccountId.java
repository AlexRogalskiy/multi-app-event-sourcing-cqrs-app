package com.progressivecoder.customerservice.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class AccountId {

    @Id
    private String id;

    private String accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customerId")
    private Customer customer;

    public AccountId() {
    }

    public AccountId(String accountId) {
        this.id = UUID.randomUUID().toString();
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
