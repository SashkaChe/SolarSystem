package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.solarsystem.data.SatelliteRepository;
import ru.solarsystem.service.PlanetsService;


@Controller
public class WebController {

    @Autowired
    private PlanetsService planetsService;

    private static void modelAddAllPlanets(Model model, PlanetsService planetsService) {
        model.addAttribute("allPlanets", planetsService.findAllPlanets());
    }

    @GetMapping("/")
    public String indexPage() {
         return "index";
    }

    @GetMapping("/sundistance")
     public String sunDistancePageGet(Model model) {
        modelAddAllPlanets(model, planetsService);
        return "sundistance";
    }

    @GetMapping("/planetdistance")
    public String planetDistancePageGet(Model model) {
        modelAddAllPlanets(model, planetsService);
        return "planetdistance";
    }

    @GetMapping("/satellites")
    public String planetSatellitesPageGet(Model model) {
        modelAddAllPlanets(model, planetsService);
        return "satellites";
    }


    @PostMapping("/satellites")
    public String planetSatellites(@RequestParam("planet") int num, Model model) {
        modelAddAllPlanets(model, planetsService);
        model.addAttribute("satelliteList", planetsService.getSatellites(planetsService.findByIndex(num)));
        model.addAttribute("planetName", planetsService.findByIndex(num).getName());
        return "satellites";
    }


    @PostMapping("/sundistance")
    public String planetList(@RequestParam("planet") int num, Model model) {
        modelAddAllPlanets(model, planetsService);
        model.addAttribute("planet", planetsService.findByIndex(num));
        return "sundistance";
    }


    @PostMapping("/planetdistance")
    public String planetList(@RequestParam("planet1") int planet1, @RequestParam("planet2") int planet2, Model model) {
        modelAddAllPlanets(model, planetsService);
        model.addAttribute("planet_1", planetsService.findByIndex(planet1).getName());
        model.addAttribute("planet_2", planetsService.findByIndex(planet2).getName());
        model.addAttribute("planet_mindistance", planetsService.getMinPlanetsDistance(planetsService.findByIndex(planet1), planetsService.findByIndex(planet2)));
        model.addAttribute("planet_maxdistance", planetsService.getMaximumPlanetDistance(planetsService.findByIndex(planet1), planetsService.findByIndex(planet2)));
        return "planetdistance";
    }

}
