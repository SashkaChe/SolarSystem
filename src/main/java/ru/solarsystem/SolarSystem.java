package ru.solarsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.solarsystem.controller.ConsoleController;
import ru.solarsystem.model.Planet;


public class SolarSystem {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.solarsystem");
        final ConsoleController consoleController = context.getBean(ConsoleController.class);

        Planet neptune = consoleController.findPlanetByName("Нептун");

        Planet venus = consoleController.findPlanetByName("Венера");

        consoleController.printMinDistanceBetween(neptune, venus);
        consoleController.printMaxDistanceBetween(neptune, venus);
        consoleController.printPlanetYears(neptune, 10000);
    }

}
