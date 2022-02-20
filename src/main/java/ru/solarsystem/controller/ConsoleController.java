package ru.solarsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.solarsystem.model.Planet;
import ru.solarsystem.service.PlanetService;

import java.util.List;


/**
 * Контроллер, который выводит информацию в консоль
 */
@Controller
public class ConsoleController {


    private final PlanetService planetService;


    @Autowired
    public ConsoleController(PlanetService planetService) {
        this.planetService = planetService;

    }

    public void allPlanets(){
        List<Planet> planets = planetService.findAllPlanets();
        System.out.println("Список планет: ");

        for (Planet obj : planets) {
            System.out.println(obj.getName());
        }

    }

    }

