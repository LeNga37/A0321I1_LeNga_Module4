package com.codegym.controller;

import com.codegym.Repository.customer.CustomerTypeRepository;
import com.codegym.entity.Customer;
import com.codegym.entity.CustomerType;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("furama")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @ModelAttribute("listCustomerType")
    public List<CustomerType> getCustomerTypes(){
        return customerTypeRepository.findAll();
    }

//    @GetMapping("/customer/list")
//    public String showListCustomer(Model model, @PageableDefault(size = 2)Pageable pageable){
//        model.addAttribute("customers",customerService.findAll(pageable));
//        return "customer/list";
//    }

    @GetMapping("/customer/list")
    public String showListCustomer(Model model, @PageableDefault(size = 2)Pageable pageable,
                                   Optional<String> key_search){
        if(key_search.isPresent()){
            model.addAttribute("customers",customerService.findAllByCustomerNameContaining(key_search.get(),pageable));
        }else {
            model.addAttribute("customers",customerService.findAll(pageable));
        }
        return "customer/list";
    }

    @GetMapping("/customer/create")
    public String displayFormCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String createCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "customer/create";
        }else {
            customerService.save(customer);
            return "redirect:list";
        }
    }

    @GetMapping("customer/edit/{customerId}")
    public String displayFormEdit(@PathVariable int customerId, Model model){
        model.addAttribute("customer",customerService.getCustomerById(customerId));
//        customerService.getCustomerById(customerId);
        return "customer/edit";
    }

    @PostMapping("customer/edit")
    public String updateCustomer(@Validated @ModelAttribute Customer customer,BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "customer/edit";
        } else {
            customerService.save(customer);
            return "redirect:list";
        }
    }

    @GetMapping("customer/delete/{customerId}")
    public String displayFormDelete(@PathVariable int customerId, Model model){
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer",customer);
        return "customer/delete";
    }

    @PostMapping("customer/actionDelete/{customerId}")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer,Pageable pageable, Model model){
        customerService.deleteCustomerById(customer.getCustomerId());
        Page<Customer> customerPage = customerService.findAll(pageable);
        model.addAttribute("customers",customerPage);
        return "customer/searchTable";
    }

    @GetMapping("customer/detail/{customerId}")
    public String displayDetail(@PathVariable int customerId, Model model){
        model.addAttribute("customer",customerService.getCustomerById(customerId));
//        customerService.getCustomerById(customerId);
        return "customer/detail";
    }

//    @ResponseBody
//    @GetMapping("customer/searchByName")
//    public ResponseEntity<List<Customer>> searchByCustomerName(@RequestParam(name = ""))
}
