//package codegym.repository;
//
//import codegym.model.Province;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.transaction.Transactional;
//
//@Repository
//@Transactional
//public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
//}

package codegym.repository;

import codegym.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends PagingAndSortingRepository<Province,Long> {
}