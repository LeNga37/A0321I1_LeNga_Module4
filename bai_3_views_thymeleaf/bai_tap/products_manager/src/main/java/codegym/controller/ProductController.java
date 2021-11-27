package codegym.controller;

import codegym.model.Product;
import codegym.service.ProductService;
import codegym.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
//    @Autowired
//    private ProductService productService;
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/")
    public String list(Model model){
        List productList = productService.findAll();
        model.addAttribute("products", productList);
        return "/list";
    }

    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(Product product){
        product.setProductId((int) (Math.random()*10000));
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("product/{productId}/edit")
    public String edit(@PathVariable int productId, Model model){
        model.addAttribute("product",productService.findById(productId));
        return "/edit";
    }

    @PostMapping("/product/update")
    public String update(Product product){
        productService.update(product.getProductId(),product);
        return "redirect:/";
    }

    @GetMapping("/product/{productId}/delete")
    public String delete(@PathVariable int productId, Model model){
        model.addAttribute("product",productService.findById(productId));
        return "/delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect){
        productService.remove(product.getProductId());
        redirect.addFlashAttribute("success","Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{productId}/view")
    public String view(@PathVariable int productId, Model model) {
        model.addAttribute("product", productService.findById(productId));
        return "/view";
    }
}