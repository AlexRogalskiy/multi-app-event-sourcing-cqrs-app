package com.progressivecoder.customerservice.entities;

import com.progressivecoder.customerservice.events.CustomerCreatedEvent;
import com.progressivecoder.customerservice.events.CustomerUpdatedEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Customer extends AbstractAggregateRoot {

    @Id
    private String customerId;

    private String customerName;

    private String customerAddress;

    @OneToMany(mappedBy = "customer")
    private Set<AccountId> accounts;

    public Customer() {
    }

    public Customer createCustomer(){
        customerId = UUID.randomUUID().toString();
        registerEvent(new CustomerCreatedEvent(customerId));
        return this;
    }

    public Customer updateCustomer(){
        registerEvent(new CustomerUpdatedEvent(customerId));
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Set<AccountId> getAccounts() {
        return accounts;
    }

    public void addAccountToCustomer(String accountId){
        if (this.accounts == null)
            this.accounts = new HashSet<>();

        AccountId newAccount = new AccountId(accountId);
        accounts.add(newAccount);
        newAccount.setCustomer(this);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
