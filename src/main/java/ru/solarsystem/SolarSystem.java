package ru.solarsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.solarsystem.controller.ConsoleController;
import ru.solarsystem.model.Planet;
import ru.solarsystem.model.planets.*;

public class SolarSystem {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.solarsystem");
        final ConsoleController consoleController = context.getBean(ConsoleController.class);

        Planet neptune = consoleController.findPlanetByName("Нептун");
        Venus obj2 = context.getBean(Venus.class);

        consoleController.printMinDistanceBetween(obj, obj2);
        consoleController.printMaxDistanceBetween(obj, obj2);
        consoleController.printPlanetSatellite(obj);


    }

}
