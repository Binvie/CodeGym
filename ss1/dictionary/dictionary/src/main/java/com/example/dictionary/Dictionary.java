package com.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    @GetMapping("")
    public String showForm() {
        return "view";
    }

    @PostMapping("view")
    public String translate(@RequestParam String word, Model model) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("love", "Tình yêu");
        stringMap.put("you", "bạn");
        stringMap.put("forever", "mãi mãi");
        String result = stringMap.get(word);

        if (result == null){
            result = "error";
        }
        model.addAttribute("result",result);
        return "view";
    }
}
