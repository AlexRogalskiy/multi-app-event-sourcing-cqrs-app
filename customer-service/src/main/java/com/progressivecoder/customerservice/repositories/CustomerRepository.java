package com.progressivecoder.customerservice.repositories;

import com.progressivecoder.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
