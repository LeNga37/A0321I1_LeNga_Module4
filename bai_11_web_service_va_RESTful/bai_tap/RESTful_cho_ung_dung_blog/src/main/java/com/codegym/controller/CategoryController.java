package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public String listCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/list";
    }
    @GetMapping("create")
    public String displayCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("categories") Category category, Model model){
        categoryService.save(category);
        return "redirect:category/list";
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("category",categoryService.getCategoryById(id));
        return "category/edit";
    }

    @PostMapping("edit")
    public String updateCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:category/list";
    }

    @GetMapping("detail/{id}")
    public String showDetailCategory(@PathVariable int id, Model model){
        model.addAttribute("category",categoryService.getCategoryById(id));
        return "category/detail";
    }

    @GetMapping("delete/{id}")
    public String showDeleteForm(@PathVariable int id, Model model){
        model.addAttribute("category",categoryService.getCategoryById(id));
        return "category/delete";
    }

    @PostMapping("delete")
    public String deleteBlog(@ModelAttribute("category") Category category){
        categoryService.deleteCategoryById(category.getCategoryId());
        return "redirect:category/list";
    }
}
