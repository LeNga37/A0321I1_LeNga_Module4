package codegym.controller;

import codegym.model.Customer;
import codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("create")
    public String displayCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("customer") Customer cus,Model model){
        customerService.save(cus);
        return "redirect:list";
    }
}
