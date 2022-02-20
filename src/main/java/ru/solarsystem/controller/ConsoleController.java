package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.solarsystem.model.Planet;
import ru.solarsystem.service.PlanetsService;

import java.util.List;


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

    public void allPlanets(){
        List<Planet> planets = planetsService.findAllPlanets();
        System.out.println("Список планет: ");

        for (Planet obj : planets) {
            System.out.println(obj.getName());
        }

    }

    }

