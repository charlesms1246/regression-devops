package com.example.regression;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/greet")
    public String greet(@RequestParam String name, Model model) {
        if (name.equals("admin")) {
            return "redirect:/success";
        } else {
            model.addAttribute("error", "Invalid User");
            return "home";
        }
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
