package com.myshop.fullstackdemo.repository;

import com.myshop.fullstackdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByEmail (String email);
}
