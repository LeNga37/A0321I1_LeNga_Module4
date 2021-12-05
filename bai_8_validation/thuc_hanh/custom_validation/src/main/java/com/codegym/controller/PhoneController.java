package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("phoneNumber",new PhoneNumber());
        return "phoneNumber/create";
    }
    @PostMapping("")
    public String checkValidate(@Valid @ModelAttribute PhoneNumber phoneNumber,Model model, BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "phoneNumber/create";
        }else {
            model.addAttribute("phoneNumber",phoneNumber.getNumber());
            return "phoneNumber/result";
        }
    }
}
