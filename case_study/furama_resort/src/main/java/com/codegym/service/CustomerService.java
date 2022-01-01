package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
//    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);

    Customer getCustomerById(int id);

    void save(Customer customer);

    void deleteCustomerById(int id);

    Page<Customer> findAllByCustomerNameContaining(String customerName, Pageable pageable);
}
