package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

        Page<Customer> findAll(Pageable pageInfo);
//    Page<Customer> findAll(Pageable pageInfo) throws Exception;

    List<Customer> search(String keyword);

    Page<Customer> search(String keyword, Pageable pageInfo);

    Customer findOne(int id) throws Exception;

    Customer save(Customer customer) throws DuplicateEmailException;

    List<Customer> save(List<Customer> customers);

    boolean exists(int id);

    List<Customer> findAll(List<Integer> ids);

    long count();

    void delete(int id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
