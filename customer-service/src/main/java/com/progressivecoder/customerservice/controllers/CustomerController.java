package com.progressivecoder.customerservice.controllers;

import com.progressivecoder.customerservice.dto.AccountCreateDTO;
import com.progressivecoder.customerservice.dto.CustomerCommandDTO;
import com.progressivecoder.customerservice.entities.Customer;
import com.progressivecoder.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> createNewCustomer(CustomerCommandDTO customerCommandDTO){
        return new ResponseEntity<>(customerService.createCustomer(customerCommandDTO), HttpStatus.CREATED);
    }

    @PutMapping(value="/customers/{customerId}")
    public ResponseEntity<Customer> updateCustomer(CustomerCommandDTO customerCommandDTO, @PathVariable(value = "customerId") String customerId){
        return new ResponseEntity<>(customerService.updateCustomer(customerId, customerCommandDTO), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/customers/{customerId}/accounts")
    public ResponseEntity<String> addAccount(@PathVariable(value = "customerId") String customerId, AccountCreateDTO accountCreateDTO){
        return new ResponseEntity<>(customerService.createAccount(customerId, accountCreateDTO), HttpStatus.CREATED);
    }
}
