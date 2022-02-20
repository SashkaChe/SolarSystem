package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.solarsystem.service.PlanetService;


@Controller
public class WebController {

    @Autowired
    private PlanetService planetService;


    private static void addAllPlanetsInModel(Model model, PlanetService planetService) {
        model.addAttribute("allPlanets", planetService.findAllPlanets());
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/sundistance")
     public String sunDistancePageGet(Model model) {
        addAllPlanetsInModel(model, planetService);
        return "sundistance";
    }

    @GetMapping("/planetdistance")
    public String planetDistancePageGet(Model model) {
        addAllPlanetsInModel(model, planetService);
        return "planetdistance";
    }

    @GetMapping("/satellites")
    public String planetSatellitesPageGet(Model model) {
        addAllPlanetsInModel(model, planetService);
        return "satellites";
    }

    @GetMapping("/planetsize")
    public String planetSizePageGet(Model model) {
        addAllPlanetsInModel(model, planetService);
        return "planetsize";
    }

    @GetMapping("/numrotation")
    public String numberRotationPageGet(Model model) {
        addAllPlanetsInModel(model, planetService);
        return "numrotation";
    }


    @PostMapping("/numrotation")
    public String numberRotation(@RequestParam("planet") int num, @RequestParam("days") int days, Model model) {
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("numberRotation", planetService.numberRotationPlanet(planetService.findByIndex(num).get(), days));
        model.addAttribute("planetName", planetService.findByIndex(num).get().getName());
        model.addAttribute("days", days);
        return "numrotation";
    }


    @PostMapping("/satellites")
    public String planetSatellites(@RequestParam("planet") int num, Model model) {
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("satelliteList", planetService.getSatellites(planetService.findByIndex(num).get()));
        model.addAttribute("planetName", planetService.findByIndex(num).get().getName());
        return "satellites";
    }

    @PostMapping("/sundistance")
    public String planetList(@RequestParam("planet") int num, Model model) {
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("planet", planetService.findByIndex(num));
        return "sundistance";
    }



    @PostMapping("/planetsize")
    public String planetSize(@RequestParam("planet1") int planet1, @RequestParam("planet2") int planet2, Model model) {
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("planetName1", planetService.findByIndex(planet1).get().getName());
        model.addAttribute("planetName2", planetService.findByIndex(planet2).get().getName());
        model.addAttribute("compareSize",
                Math.ceil(planetService.compareSizePlanets(
                        planetService.findByIndex(planet1).get(),
                        planetService.findByIndex(planet2).get())
                        * Math.pow(10, 3)) / Math.pow(10, 3));
        return "planetsize";
    }


    @PostMapping("/planetdistance")
    public String planetList(@RequestParam("planet1") int planet1, @RequestParam("planet2") int planet2, Model model) {
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("planet_1", planetService.findByIndex(planet1).get().getName());
        model.addAttribute("planet_2", planetService.findByIndex(planet2).get().getName());
        model.addAttribute("planet_mindistance",
                planetService.getMinPlanetsDistance(planetService.findByIndex(planet1).get(), planetService.findByIndex(planet2).get()));
        model.addAttribute("planet_maxdistance",
                planetService.getMaximumPlanetDistance(planetService.findByIndex(planet1).get(), planetService.findByIndex(planet2).get()));
        return "planetdistance";
    }

}
