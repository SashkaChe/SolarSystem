package ru.solarsystem.service;

import org.springframework.stereotype.Component;
import ru.solarsystem.model.planets.Planet;
import ru.solarsystem.model.satellite.Satellite;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class PlanetsService {

    public void getPlanetsDistance(Planet planet1, Planet planet2) {

        System.out.println("Расстояние между планетами " + planet1.getName() + " и " + planet2.getName() + ": "
                + new DecimalFormat( "#,###" ).format(Math.abs(planet1.getDistance() - planet2.getDistance())) + " км.");

    }


    public void getPlanetSatellite(Planet planet) {

        List<Satellite> satellite = planet.getSat();

        if (satellite == null) {
            System.out.println("У планеты " + planet.getName() + " нет спутников");
        } else {

            System.out.println("Количество спутников у планеты "  + planet.getName() + ": "  + satellite.size());

            for (Satellite x : satellite) {
                System.out.print(x.getName() + " ");
            }

        }

    }

}
