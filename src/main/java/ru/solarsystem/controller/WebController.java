package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.solarsystem.service.PlanetsService;
import ru.solarsystem.service.SatellitesService;


@Controller
public class WebController {

    @Autowired
    private PlanetsService planetsService;

    @Autowired
    private SatellitesService satellitesService;


    private static void addAllPlanetsInModel(Model model, PlanetsService planetsService) {
        model.addAttribute("allPlanets", planetsService.findAllPlanets());
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/sundistance")
     public String sunDistancePageGet(Model model) {
        addAllPlanetsInModel(model, planetsService);
        return "sundistance";
    }

    @GetMapping("/planetdistance")
    public String planetDistancePageGet(Model model) {
        addAllPlanetsInModel(model, planetsService);
        return "planetdistance";
    }

    @GetMapping("/satellites")
    public String planetSatellitesPageGet(Model model) {
        addAllPlanetsInModel(model, planetsService);
        return "satellites";
    }

    @GetMapping("/planetsize")
    public String planetSizePageGet(Model model) {
        addAllPlanetsInModel(model, planetsService);
        return "planetsize";
    }

    @GetMapping("/numrotation")
    public String numberRotationPageGet(Model model) {
        addAllPlanetsInModel(model, planetsService);
        return "numrotation";
    }


    @PostMapping("/numrotation")
    public String numberRotation(@RequestParam("planet") int num, @RequestParam("days") int days, Model model) {
        addAllPlanetsInModel(model, planetsService);
        model.addAttribute("numberRotation", planetsService.numberRotationPlanet(planetsService.getById(num), days));
        model.addAttribute("planetName", planetsService.getById(num).getName());
        model.addAttribute("days", days);
        return "numrotation";
    }


    @PostMapping("/satellites")
    public String planetSatellites(@RequestParam("planet") int num, Model model) {
        addAllPlanetsInModel(model, planetsService);
        model.addAttribute("satelliteList", planetsService.getSatellites(planetsService.getById(num)));
        model.addAttribute("planetName", planetsService.getById(num).getName());
        return "satellites";
    }

    @PostMapping("/sundistance")
    public String planetList(@RequestParam("planet") int num, Model model) {
        addAllPlanetsInModel(model, planetsService);
        model.addAttribute("planet", planetsService.getById(num));
        return "sundistance";
    }

/*

    @PostMapping("/planetsize")
    public String planetSize(@RequestParam("planet1") int planet1, @RequestParam("planet2") int planet2, Model model) {
        addAllPlanetsInModel(model, planetsService);
        model.addAttribute("planetName1", planetsService.findByIndex(planet1).getName());
        model.addAttribute("planetName2", planetsService.findByIndex(planet2).getName());
        model.addAttribute("compareSize", Math.ceil(planetsService.compareSizePlanets(planetsService.findByIndex(planet1), planetsService.findByIndex(planet2)) * Math.pow(10, 3)) / Math.pow(10, 3));
        return "planetsize";
    }


    @PostMapping("/planetdistance")
    public String planetList(@RequestParam("planet1") int planet1, @RequestParam("planet2") int planet2, Model model) {
        addAllPlanetsInModel(model, planetsService);
        model.addAttribute("planet_1", planetsService.findByIndex(planet1).getName());
        model.addAttribute("planet_2", planetsService.findByIndex(planet2).getName());
        model.addAttribute("planet_mindistance", planetsService.getMinPlanetsDistance(planetsService.findByIndex(planet1), planetsService.findByIndex(planet2)));
        model.addAttribute("planet_maxdistance", planetsService.getMaximumPlanetDistance(planetsService.findByIndex(planet1), planetsService.findByIndex(planet2)));
        return "planetdistance";
    }
*/
}
