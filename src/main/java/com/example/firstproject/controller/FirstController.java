package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String NiceToMeetYou(Model model){
        model.addAttribute("username", "성훈");
        return "hello";
    }

    @GetMapping("/bye")
    public String GoodBye(Model model){
        model.addAttribute("nickname", "seonghun");
        return "bye";
    }
}
