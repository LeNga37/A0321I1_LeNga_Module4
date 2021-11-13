package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String showForm(){
        return ("calculator");
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam float number1, float number2, String operator, Model model){
        model.addAttribute("number1",number1);
        model.addAttribute("operator",operator);
        model.addAttribute("number2",number2);
        float result;
        switch (operator){
            case "+":
                result = number1+number2;
                break;
            case "-":
                result = number1-number2;
                break;
            case "*":
                result = number1*number2;
                break;
            case "/":
                result = number1/number2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        model.addAttribute("result",result);
        return ("calculator");
    }
}
