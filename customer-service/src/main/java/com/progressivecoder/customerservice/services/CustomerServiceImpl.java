package com.progressivecoder.customerservice.services;

import com.progressivecoder.customerservice.dto.AccountCreateDTO;
import com.progressivecoder.customerservice.dto.CustomerCommandDTO;
import com.progressivecoder.customerservice.entities.Customer;
import com.progressivecoder.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerCommandDTO customerCommandDTO) {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(customerCommandDTO.getCustomerName());
        newCustomer.setCustomerAddress(customerCommandDTO.getCustomerAddress());

        return customerRepository.save(newCustomer.createCustomer());
    }

    @Override
    public Customer updateCustomer(String customerId, CustomerCommandDTO customerCommandDTO) {
        if (customerRepository.findById(customerId).isPresent()){
            Customer customer = customerRepository.findById(customerId).get();
            customer.setCustomerName(customerCommandDTO.getCustomerName());
            customer.setCustomerAddress(customerCommandDTO.getCustomerAddress());
            return customerRepository.save(customer.updateCustomer());
        }else{
            throw new EntityNotFoundException("No customer present with customer id: " + customerId);
        }

    }

    @Override
    public String createAccount(String customerId, AccountCreateDTO accountCreateDTO) {
        return null;
    }
}
