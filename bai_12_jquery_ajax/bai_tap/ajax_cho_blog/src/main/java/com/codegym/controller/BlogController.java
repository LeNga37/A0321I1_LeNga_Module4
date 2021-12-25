package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("list")
    public String showListBlogByTitle(Model model, @PageableDefault(size = 3) Pageable  pageable,
                                       Optional<String> key_search){
        if(key_search.isPresent()){
            model.addAttribute("blogs",blogService.findByTitleContaining(key_search.get(),pageable));
        }else {
            model.addAttribute("blogs", blogService.findAllBlog(pageable));

        }
        return "blog/list";
    }

    @GetMapping("create")
    public String displayCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("blogs") Blog blog, Model model){
        blogService.save(blog);
        return "redirect:list";
    }

//    @GetMapping("list")
//    public String listBlog(Model model, Pageable pageable) {
//        model.addAttribute("blogs", blogService.findAllPageable(pageable));
//        return "blog/list";
//    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.getBlogById(id));
        return "blog/edit";
    }

    @PostMapping("edit")
    public String updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:list";
    }

    @GetMapping("detail/{id}")
    public String showDetailBlog(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.getBlogById(id));
        return "blog/detail";
    }

    @GetMapping("delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.getBlogById(id));
        return "blog/delete";
    }

    @PostMapping("delete")
    public String deleteBlog(@ModelAttribute("blog") Blog blog){
        blogService.deleteBlogById(blog.getId());
        return "redirect:list";
    }

    @ResponseBody
    @GetMapping("searchTitleBlog")
    public ResponseEntity<List<Blog>> searchTitleBlog(@RequestParam(name="titleBlog", required = false) String title, Model model){
        List<Blog> blogs = blogService.findByTitle(title);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}

