package ru.solarsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;
import ru.solarsystem.service.PlanetsService;

import java.util.List;

@RestController("/rest")
public class PlanetRestController {

    private final PlanetsService planetService;

    public PlanetRestController(PlanetsService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planetList")
    public List<Planet> listPlanets() {
        return planetService.allPlanets();
    }

    @GetMapping("/planet_distance_max")
    public long maxPlanetDistance(@RequestParam int firstPlanetId,
                                    @RequestParam int secondPlanetId) {
        final Planet firstPlanet = planetService.findByIndex(firstPlanetId);
        final Planet secondPlanet = planetService.findByIndex(secondPlanetId);
        return planetService.getMaximumPlanetDistance(firstPlanet, secondPlanet);
    }

    @GetMapping("/planet_distance_min")
    public long minPlanetDistance(@RequestParam int firstPlanetId,
                                  @RequestParam int secondPlanetId) {
        final Planet firstPlanet = planetService.findByIndex(firstPlanetId);
        final Planet secondPlanet = planetService.findByIndex(secondPlanetId);
        return planetService.getMinPlanetsDistance(firstPlanet, secondPlanet);
    }

    @GetMapping("/planet/{id}/sun_distance")
    public long distanceToSun(@PathVariable int planetId) {
          return planetService.findByIndex(planetId).getDistanceToSun();
    }

    @GetMapping("/planet/{id}/satellites")
    public List<Satellite> getSatellites(@PathVariable int id) {
         return planetService.findByIndex(id).getSatellites();
    }

    @GetMapping("/planet/{id}/size")
    public int getPlanetSize(@PathVariable int id) {
        return planetService.findByIndex(id).getDiameter();
    }

    @GetMapping("/planet/{id}/numrotation")
    public double getNumRoration(@PathVariable int id, @RequestParam int days) {
        return planetService.numberRotationPlanet(planetService.findByIndex(id), days);
    }



}
