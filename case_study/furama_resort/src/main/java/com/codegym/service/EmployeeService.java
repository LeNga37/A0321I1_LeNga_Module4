package com.codegym.service;

import com.codegym.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee getEmployeeById(int id);

    void save(Employee employee);

    void deleteEmployeeById(int id);

    Page<Employee> findAllByEmployeeNameContaining(String employeeName, Pageable pageable);
}
