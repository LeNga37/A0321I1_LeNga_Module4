package com.codegym.controller;

import com.codegym.Repository.employee.DivisionRepository;
import com.codegym.Repository.employee.EducationDegreeRepository;
import com.codegym.Repository.employee.PositionRepository;
import com.codegym.entity.*;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("furama")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @ModelAttribute("listEducationDegree")
    public List<EducationDegree> getEducationDegree(){
        return educationDegreeRepository.findAll();
    }

    @Autowired
    PositionRepository positionRepository;

    @ModelAttribute("listPosition")
    public List<Position> getPosition(){
        return positionRepository.findAll();
    }

    @Autowired
    DivisionRepository divisionRepository;

    @ModelAttribute("listDivision")
    public List<Division> getDivision(){
        return divisionRepository.findAll();
    }

    @GetMapping("/employee/list")
    public String showListEmployee(Model model, @PageableDefault(size = 2) Pageable pageable,
                                   Optional<String> key_search){
        if(key_search.isPresent()){
            model.addAttribute("employees",employeeService.findAllByEmployeeNameContaining(key_search.get(),pageable));
        }else {
            model.addAttribute("employees",employeeService.findAll(pageable));
        }
        return "employee/list";
    }

    @GetMapping("/employee/create")
    public String displayFormCreate(Model model){
        model.addAttribute("employee",new Employee());
        return "employee/create";
    }

    @PostMapping("/employee/create")
    public String createCustomer(@Validated @ModelAttribute("employee")  Employee employee, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "employee/create";
        }else {
            employeeService.save(employee);
            return "redirect:list";
        }
    }

}
