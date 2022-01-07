package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.solarsystem.model.planets.Planet;
import ru.solarsystem.model.satellite.Satellite;
import ru.solarsystem.service.PlanetsService;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Контроллер, который выводит информацию в консоль
 */
@Controller
public class ConsoleController {

    private final PlanetsService planetsService;

    @Autowired
    public ConsoleController(PlanetsService planetsService) {
        this.planetsService = planetsService;
    }


    public void printMinDistanceBetween(Planet planet1, Planet planet2) {
        final long distance = planetsService.getMinPlanetsDistance(planet1, planet2);
        System.out.println("Минимальное расстояние между планетами " + planet1.getName() + " и " + planet2.getName() + ": "
                + new DecimalFormat( "#,###" ).format(distance) + " км.");
    }

    public void printMaxDistanceBetween(Planet planet1, Planet planet2) {
        final long distance = planetsService.getMaximumPlanetDistance(planet1, planet2);
        System.out.println("Максимальное расстояние между планетами " + planet1.getName() + " и " + planet2.getName() + ": "
                + new DecimalFormat( "#,###" ).format(Math.abs(planet1.getDistance() + planet2.getDistance())) + " км.");
    }

    public void printPlanetSatellite(Planet planet) {
        List<Satellite> satelliteList = planetsService.getSatellites(planet);
        if (satelliteList == null) {
            System.out.println("У планеты " + planet.getName() + " нет спутников");
        } else {
            System.out.println("Количество спутников у планеты "  + planet.getName() + ": "  + satelliteList.size());
            for (Satellite x : satelliteList) {
                System.out.print(x.getName() + " ");
            }
        }
    }

}
