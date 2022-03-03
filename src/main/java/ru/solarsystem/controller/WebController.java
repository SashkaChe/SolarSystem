package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.solarsystem.model.Planet;
import ru.solarsystem.service.PlanetService;

import java.text.DecimalFormat;


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

        Planet planet = planetService.findByIndex(num);
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("numberRotation", planetService.numberRotationPlanet(planet, days));
        model.addAttribute("planetName", planet.getName());
        model.addAttribute("days", days);
        return "numrotation";
    }


    @PostMapping("/satellites")
    public String planetSatellites(@RequestParam("planet") int num, Model model) {
        Planet planet = planetService.findByIndex(num);
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("satelliteList", planetService.getSatellites(planet));
        model.addAttribute("planetName", planet.getName());
        return "satellites";
    }

    @PostMapping("/sundistance")
    public String planetList(@RequestParam("planet") int num, Model model) {
        addAllPlanetsInModel(model, planetService);
        model.addAttribute("planet", planetService.findByIndex(num));
        return "sundistance";
    }



    @PostMapping("/planetsize")
    public String planetSize(@RequestParam("planet1") int planetId1, @RequestParam("planet2") int planetId2, Model model) {

        Planet planetFirst = planetService.findByIndex(planetId1);
        Planet planetSecond = planetService.findByIndex(planetId2);

        addAllPlanetsInModel(model, planetService);
        model.addAttribute("planetName1", planetFirst.getName());
        model.addAttribute("planetName2", planetSecond.getName());
        final double result = planetService.compareSizePlanets(planetFirst, planetSecond);
        model.addAttribute("compareSize", new DecimalFormat("###.###").format(result));

        return "planetsize";
    }


    @PostMapping("/planetdistance")
    public String planetList(@RequestParam("planet1") int planetId1, @RequestParam("planet2") int planetId2, Model model) {

        Planet planetFirst = planetService.findByIndex(planetId1);
        Planet planetSecond = planetService.findByIndex(planetId2);

        addAllPlanetsInModel(model, planetService);
        model.addAttribute("planetId1", planetFirst.getName());
        model.addAttribute("planetId2", planetSecond.getName());
        model.addAttribute("planet_mindistance",
                planetService.getMinPlanetsDistance(planetFirst, planetSecond));
        model.addAttribute("planet_maxdistance",
                planetService.getMaximumPlanetDistance(planetFirst, planetSecond));
        return "planetdistance";
    }

}
