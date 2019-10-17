package com.progressivecoder.customerservice.events;

import com.progressivecoder.customerservice.entities.Customer;
import com.progressivecoder.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class CustomerEventProcessor {

    @Autowired
    private CustomerRepository customerRepository;

    @Async
    @TransactionalEventListener
    public void handleCustomerCreatedEvent(CustomerCreatedEvent customerCreatedEvent){

        Customer customer = customerRepository.findById(customerCreatedEvent.getCustomerId()).get();

        System.out.println("New Customer Created: " + customer.toString());

    }

    @Async
    @TransactionalEventListener
    public void handleCustomerUpdatedEvent(CustomerUpdatedEvent customerUpdatedEvent){

        Customer customer = customerRepository.findById(customerUpdatedEvent.getCustomerId()).get();

        System.out.println("Customer Updated: " + customer.toString());

    }
}
