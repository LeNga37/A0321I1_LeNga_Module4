package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @Autowired
    private UserService userService;

    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "create";
        }
        userService.save(user);
        return "result";
    }

//    @GetMapping("list")
//    public String showListUser(Model model){
//        model.addAttribute("users",userService.findAll());
//        return "list";
//    }
}
