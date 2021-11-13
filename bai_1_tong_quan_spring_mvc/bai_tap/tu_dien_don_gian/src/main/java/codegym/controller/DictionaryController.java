package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("")
    public String showForm() {
        return ("dictionary");
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String eng, Model model) {
        Map<String, String> dictionary=new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Sách");
        dictionary.put("note", "Máy tính");
        dictionary.put("computer", "Máy tính");
        dictionary.put("table", "Bàn");
        dictionary.put("image", "Hình ảnh");
        dictionary.put("sun", "Mặt trời");

        model.addAttribute("eng",eng);
        String vn = dictionary.get(eng);
        if(vn!=null){
            model.addAttribute("vn",vn);
        }else {
            model.addAttribute("vn","Not found");
        }
        return ("dictionary");
    }
//    @PostMapping("/translate")
//    public String translate(@RequestParam String eng, Model model) {
//        String vn;
//        switch (eng) {
//            case "book":
//                vn = "Sách";
//                break;
//            case "table":
//                vn = "Bàn";
//                break;
//            case "note":
//                vn = "Vở";
//                break;
//            case "mouse":
//                vn = "Chuột";
//                break;
//            case "computer":
//                vn = "Máy tính";
//                break;
//            default:
//                vn = "Không tìm thấy";
//                break;
//        }
//        model.addAttribute("eng",eng);
//        model.addAttribute("vn",vn);
//        return ("dictionary");
//    }
}
