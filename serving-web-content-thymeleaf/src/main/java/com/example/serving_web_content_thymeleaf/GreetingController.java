package com.example.serving_web_content_thymeleaf;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", defaultValue = "World", required = false)
                           String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }
}
