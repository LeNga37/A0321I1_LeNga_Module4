package codegym.controller;

import codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping("")
    public String displayFormUpdate(Model model){
        model.addAttribute("email",new Email());
        String[] itemsLanguages = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        String[] itemsPageSize = new String[]{"5", "10", "15", "25", "50", "100"};
        model.addAttribute("itemsLanguages",itemsLanguages);
        model.addAttribute("itemsPageSize",itemsPageSize);
        return "update";
    }

    @PostMapping("/update")
    public String update (@ModelAttribute Email email, Model model){
        model.addAttribute("languages",email.getLanguages());
        model.addAttribute("pageSize",email.getPageSize());
        model.addAttribute("spamFilter",email.isSpamFilter());
        model.addAttribute("signature",email.getSignature());
        return "info";
    }
}
