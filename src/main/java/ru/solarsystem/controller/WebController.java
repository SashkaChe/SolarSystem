package ru.solarsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/sundistance")
    public String sunDistancePage() {
        return "sundistance";
    }

}
