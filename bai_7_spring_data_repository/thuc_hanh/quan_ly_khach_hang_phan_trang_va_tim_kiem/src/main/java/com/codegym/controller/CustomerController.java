//package codegym.controller;
//
//import codegym.model.Customer;
//import codegym.model.Province;
//import codegym.service.CustomerService;
//import codegym.service.ProvinceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/customer")
//public class CustomerController {
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private ProvinceService provinceService;
//    @ModelAttribute("provinces")
//    public Iterable<Province> provinces(){
//        return provinceService.findAll();
//    }
//    @GetMapping("/index")
//    public ModelAndView getIndex(){
//        Iterable<Customer> customers=customerService.findAll();
//        ModelAndView modelAndView=new ModelAndView("customer/list");
//        modelAndView.addObject("customers",customers);
//        return modelAndView;
//    }
//    @GetMapping("/showCreate")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("customer/create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView save(@ModelAttribute("customer") Customer customer){
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("customer/create");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message", "New customer created successfully");
//        return modelAndView;
//    }
//    @GetMapping("/showEdit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/edit");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView update(@ModelAttribute("customer") Customer customer){
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("customer/edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "customer updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/showDelete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/delete");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/delete")
//    public String deleteProvince(@ModelAttribute("customer") Customer customer){
//        customerService.remove(customer.getId());
//        return "redirect:customer/list";
//    }
//}


package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.CustomerService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/customers")
    public ModelAndView getIndex(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Customer> customers;
        if(s.isPresent()){
            customers = customerService.findAllByFirstNameContaining(s.get(),pageable);
        } else {
            customers = customerService.findAll( pageable);
        }
        ModelAndView modelAndView=new ModelAndView("customer/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView save(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/edit-customer")
    public ModelAndView update(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/delete-customer")
    public String deleteProvince(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}
