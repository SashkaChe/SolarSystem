package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.Satellite;
import ru.solarsystem.service.PlanetsService;
import ru.solarsystem.service.SatellitesService;

import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Math.round;

/**
 * Контроллер, который выводит информацию в консоль
 */
@Controller
public class ConsoleController {

    private final PlanetsService planetsService;
    private final SatellitesService satellitesService;

    @Autowired
    public ConsoleController(PlanetsService planetsService, SatellitesService satellitesService) {
        this.planetsService = planetsService;
        this.satellitesService = satellitesService;
    }


    public void printMinDistanceBetween(Planet planet1, Planet planet2) {
        final long distance = planetsService.getMinPlanetsDistance(planet1, planet2);
        System.out.println("Минимальное расстояние между планетами " + planet1.getName() + " и " + planet2.getName() + ": "
                + new DecimalFormat( "#,###" ).format(distance) + " км.");
    }

    public void printMaxDistanceBetween(Planet planet1, Planet planet2) {
        final long distance = planetsService.getMaximumPlanetDistance(planet1, planet2);
        System.out.println("Максимальное расстояние между планетами " + planet1.getName() + " и " + planet2.getName() + ": "
                + new DecimalFormat( "#,###" ).format(planetsService.getMaximumPlanetDistance(planet1,planet2))
                + " км.");
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
            System.out.println();
        }
    }

    public Planet findPlanetByName(String name) {
        return planetsService.findPlanetByName(name);
    }

    public void printPlanetYears(Planet planet, int days) {
        int planet_year = planet.getYearDuration();
        System.out.println(String.format("За " + days + " земных суток " + planet.getName() + " совершит " + "%.2f" + " оборота вокруг Солнца", (double) days/planet_year));
        System.out.println();
    }


}
