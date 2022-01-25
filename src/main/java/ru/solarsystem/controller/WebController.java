package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.solarsystem.service.PlanetsService;


@Controller
public class WebController {

    @Autowired
    private PlanetsService planetsService;

    @GetMapping("/sundistance")
    public String indexPage() {
         return "index";
    }

    @GetMapping("/sundistance")
     public String sunDistancePageGet() {
        return "sundistance";
    }


    @PostMapping("/sundistance")
    public String sunDistancePagePost(@RequestParam("planet") String name, Model model) {
        model.addAttribute("planet", planetsService.findPlanetByName(name));
        return "sundistance";
    }

}
