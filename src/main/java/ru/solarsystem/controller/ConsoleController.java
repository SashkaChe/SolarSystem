package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.solarsystem.model.planets.Planet;
import ru.solarsystem.service.PlanetsService;

import java.text.DecimalFormat;

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


    public void printDistanceBetween(Planet planet1, Planet planet2) {
        final long distance = planetsService.getPlanetsDistance(planet1, planet2);
        System.out.println("Расстояние между планетами " + planet1.getName() + " и " + planet2.getName() + ": "
                + new DecimalFormat( "#,###" ).format(distance) + " км.");
    }
}
