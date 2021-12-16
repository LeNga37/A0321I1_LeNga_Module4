package com.codegym.controller;

import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public String listProduct(Model model){
        model.addAttribute("products",productService.findAll());
        return "list";
    }

    @GetMapping("detail/{productId}")
    public String showDetailProduct(@PathVariable Integer productId, Model model){
        model.addAttribute("product",productService.findById(productId));
        return "detail";
    }
}
