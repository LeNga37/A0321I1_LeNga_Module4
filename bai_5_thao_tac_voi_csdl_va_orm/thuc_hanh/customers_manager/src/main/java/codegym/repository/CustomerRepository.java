package codegym.repository;

import codegym.model.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(int id);
    List<Customer> getList();
    void save(Customer customer);
    void update(Customer customer);
    void deleteCustomerById(int id);
}
