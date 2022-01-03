package ru.solarsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.solarsystem.model.planets.*;
import ru.solarsystem.service.PlanetsService;

public class SolarSystem {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.solarsystem");

        Jupiter obj = context.getBean(Jupiter.class);
        Venus obj2 = context.getBean(Venus.class);

        context.getBean(PlanetsService.class).getPlanetsDistance(obj, obj2);
        context.getBean(PlanetsService.class).getPlanetSatellite(obj2);

    }

}
