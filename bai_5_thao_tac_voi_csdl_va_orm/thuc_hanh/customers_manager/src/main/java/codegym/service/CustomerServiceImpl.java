package codegym.service;

import codegym.model.Customer;
import codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getList() {
        return customerRepository.getList();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteCustomerById(id);
    }
}
