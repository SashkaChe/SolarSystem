package ru.solarsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.solarsystem.controller.ConsoleController;
import ru.solarsystem.model.Planet;
import ru.solarsystem.mvc_config.SpringConfig;


public class SolarSystem {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.solarsystem");
        final ConsoleController consoleController = context.getBean(ConsoleController.class);

        Planet mars = consoleController.findPlanetByName("Марс");

        Planet venus = consoleController.findPlanetByName("Венера");

        consoleController.printMinDistanceBetween(mars, venus);
        consoleController.printMaxDistanceBetween(mars, venus);
    }

}
