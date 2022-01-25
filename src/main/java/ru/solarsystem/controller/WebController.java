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

    @GetMapping("/")
    public String indexPage() {
         return "index";
    }

    @GetMapping("/sundistance")
     public String sunDistancePageGet(Model model) {
        model.addAttribute("allPlanets", planetsService.findAllPlanets());
        return "sundistance";
    }


    @PostMapping("/sundistance")
    public String sunDistancePagePost(@RequestParam("planet") int num, Model model) {
        model.addAttribute("allPlanets", planetsService.findAllPlanets());
        model.addAttribute("planet", planetsService.findByIndex(num));
        return "/sundistance";
    }

}
