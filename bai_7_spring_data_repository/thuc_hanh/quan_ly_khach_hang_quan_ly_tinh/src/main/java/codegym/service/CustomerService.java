package codegym.service;

import codegym.model.Customer;
import codegym.model.Province;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Province> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
