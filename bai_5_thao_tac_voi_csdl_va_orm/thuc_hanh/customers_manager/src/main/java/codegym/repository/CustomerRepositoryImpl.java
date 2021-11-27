package codegym.repository;

import codegym.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Autowired
    EntityManager entityManager;
    @Override
    public Customer getCustomerById(int id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public List<Customer> getList() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void deleteCustomerById(int id) {
        Customer entity =  entityManager.find(Customer.class,id);
        entityManager.remove(entity);
    }
}
