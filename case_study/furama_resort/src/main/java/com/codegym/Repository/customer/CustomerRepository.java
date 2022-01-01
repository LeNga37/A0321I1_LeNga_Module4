package com.codegym.Repository.customer;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    Page<Customer> findCustomerByCustomerName(String name, Pageable pageable);
    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
}
