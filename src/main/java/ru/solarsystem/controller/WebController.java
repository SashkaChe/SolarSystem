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

    @GetMapping("/planetdistance")
    public String planetDistancePageGet(Model model) {
        model.addAttribute("allPlanets", planetsService.findAllPlanets());
        return "planetdistance";
    }


    @PostMapping("/sundistance")
    public String planetList(@RequestParam("planet") int num, Model model) {
        model.addAttribute("allPlanets", planetsService.findAllPlanets());
        model.addAttribute("planet", planetsService.findByIndex(num));
        return "sundistance";
    }


    @PostMapping("/planetdistance")
    public String planetList(@RequestParam("planet1") int planet1, @RequestParam("planet2") int planet2, Model model) {
        model.addAttribute("allPlanets", planetsService.findAllPlanets());
        model.addAttribute("planet_1", planetsService.findByIndex(planet1));
        model.addAttribute("planet_2", planetsService.findByIndex(planet2));
        model.addAttribute("planet_mindistance", planetsService.getMinPlanetsDistance(planetsService.findByIndex(planet1), planetsService.findByIndex(planet2)));
        model.addAttribute("planet_maxdistance", planetsService.getMaximumPlanetDistance(planetsService.findByIndex(planet1), planetsService.findByIndex(planet2)));
        return "planetdistance";
    }

}
