//package codegym.service;
//
//import codegym.model.Customer;
//import codegym.model.Province;
//import codegym.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
////@Service
//public class CustomerServiceImpl implements CustomerService{
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public Iterable<Customer> findAll() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public Customer findById(Long id) {
//        return customerRepository.findById(id).orElse(null);
////        return customerRepository.findById(id);
//
//    }
//
//    @Override
//    public void save(Customer customer) {
//        customerRepository.save(customer);
//    }
//
//    @Override
//    public void remove(Long id) {
//        customerRepository.deleteById(id);
//    }
//
//    @Override
//    public Iterable<Customer> findAllByProvince(Province province) {
//        return customerRepository.findAllByProvince(province);
//    }
//}

package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepo;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepo.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return customerRepo.findAllByFirstNameContaining(firstname, pageable);
    }
}