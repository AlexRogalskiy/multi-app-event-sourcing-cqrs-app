package com.progressivecoder.customerservice.services;

import com.progressivecoder.customerservice.dto.AccountCreateDTO;
import com.progressivecoder.customerservice.dto.CustomerCommandDTO;
import com.progressivecoder.customerservice.entities.Customer;

public interface CustomerService {
    public Customer createCustomer(CustomerCommandDTO customerCommandDTO);
    public Customer updateCustomer(String customerId, CustomerCommandDTO customerCommandDTO);
    public String createAccount(String customerId, AccountCreateDTO accountCreateDTO);
}
