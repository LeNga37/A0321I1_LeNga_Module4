//package codegym.repository;
//
//import codegym.model.Customer;
//import codegym.model.Province;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//@Repository
//@Transactional
////@ComponentScan
//public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
//    Iterable<Customer> findAllByProvince(Province province);
//}

package codegym.repository;

import codegym.model.Customer;
import codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}